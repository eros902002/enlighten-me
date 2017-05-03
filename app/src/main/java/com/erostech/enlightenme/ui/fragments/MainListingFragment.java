package com.erostech.enlightenme.ui.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.erostech.enlightenme.App;
import com.erostech.enlightenme.R;
import com.erostech.enlightenme.adapters.ImageListAdapter;
import com.erostech.enlightenme.callbacks.ImageListAdapterCallback;
import com.erostech.enlightenme.config.Config;
import com.erostech.enlightenme.data.models.Image;
import com.erostech.enlightenme.listeners.PaginationScrollListener;
import com.erostech.enlightenme.ui.components.DaggerMainListingComponent;
import com.erostech.enlightenme.ui.contracts.MainListingContract;
import com.erostech.enlightenme.ui.modules.MainListingModule;
import com.erostech.enlightenme.ui.presenters.MainListingPresenter;

import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainListingFragment extends Fragment implements MainListingContract.View, ImageListAdapterCallback {

    private static final int STARTING_PAGE = 1;
    private static final int INITIAL_TOTAL_PAGES = 5;

    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private LinearLayout mErrorLayout;
    private Button mRetryButton;
    private TextView mErrorText;

    private ImageListAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    private String query = "";

    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int totalPages = INITIAL_TOTAL_PAGES;
    private int currentPage = STARTING_PAGE;

    @Inject
    MainListingPresenter mPresenter;

    public MainListingFragment() {
    }

    public static MainListingFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MainListingFragment fragment = new MainListingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_listing, container, false);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progress_indicator);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mErrorLayout = (LinearLayout) view.findViewById(R.id.error_layout);
        mRetryButton = (Button) view.findViewById(R.id.error_btn_retry);
        mErrorText = (TextView) view.findViewById(R.id.error_txt_cause);

        DaggerMainListingComponent.builder()
                .appComponent(((App) getActivity().getApplicationContext()).getAppComponent())
                .mainListingModule(new MainListingModule(this))
                .build()
                .inject(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new ImageListAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new PaginationScrollListener(mLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage += 1;
                loadNextPage();
            }

            @Override
            public int getTotalPageCount() {
                return totalPages;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFirstPage();
            }
        });
    }

    @Override
    public void showInitialPage(List<Image> images, int totalImages) {
        hideErrorView();

        mProgressBar.setVisibility(View.GONE);

        mAdapter.addAll(images);

        if (currentPage <= totalImages) {
            mAdapter.addLoadingFooter();
        } else {
            isLastPage = true;
        }

        totalPages = totalImages / Config.getPageSize();
        if (totalImages % Config.getPageSize() > 0) {
            totalPages++;
        }

    }

    @Override
    public void showNextPage(List<Image> images) {
        mAdapter.removeLoadingFooter();
        isLoading = false;

        mAdapter.addAll(images);

        if (currentPage != totalPages) {
            mAdapter.addLoadingFooter();
        } else {
            isLastPage = true;
        }
    }

    @Override
    public void showInitialPageError(Throwable throwable) {
        showErrorView(throwable);
    }

    @Override
    public void showNextPageError(Throwable throwable) {
        mAdapter.showRetry(true, fetchErrorMessage(throwable));
    }

    @Override
    public void retryPageLoad() {
        loadNextPage();
    }

    private void loadFirstPage() {
        mPresenter.loadInitialPage(query);
    }

    private void loadNextPage() {
        mPresenter.loadNextPage(query, currentPage);
    }

    private void search() {

    }

    private void showErrorView(Throwable throwable) {
        if (mErrorLayout.getVisibility() == View.GONE) {
            mErrorLayout.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.GONE);

            mErrorText.setText(fetchErrorMessage(throwable));
        }
    }

    private String fetchErrorMessage(Throwable throwable) {
        String errorMessage = getResources().getString(R.string.error_msg_unknown);

        if (!isNetworkConnected()) {
            errorMessage = getResources().getString(R.string.error_msg_no_internet);
        } else if (throwable instanceof TimeoutException) {
            errorMessage = getResources().getString(R.string.error_msg_timeout);
        }

        return errorMessage;
    }

    private void hideErrorView() {
        if (mErrorLayout.getVisibility() == View.VISIBLE) {
            mErrorLayout.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
