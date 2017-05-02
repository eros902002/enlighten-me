package com.erostech.enlightenme.ui.presenters;

import com.erostech.enlightenme.api.ImageSearchService;
import com.erostech.enlightenme.config.Config;
import com.erostech.enlightenme.data.models.ImageSearchResponse;
import com.erostech.enlightenme.ui.contracts.MainListingContract;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by erosgarciaponte on 02/05/2017.
 */

public class MainListingPresenter implements MainListingContract.Presenter {
    private ImageSearchService mService;
    private MainListingContract.View mView;

    @Inject
    public MainListingPresenter(Retrofit retrofit, MainListingContract.View view) {
        this.mService = retrofit.create(ImageSearchService.class);
        this.mView = view;
    }

    @Override
    public void loadInitialPage(String query) {
        loadImages(query, 1, new Observer<ImageSearchResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (mView != null) {
                    mView.showInitialPageError(e);
                }
            }

            @Override
            public void onNext(ImageSearchResponse imageSearchResponse) {
                if (mView != null) {
                    mView.showInitialPage(imageSearchResponse.getData(), imageSearchResponse.getTotalCount());
                }
            }
        });
    }

    @Override
    public void loadNextPage(String query, int page) {
        loadImages(query, page, new Observer<ImageSearchResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (mView != null) {
                    mView.showNextPageError(e);
                }
            }

            @Override
            public void onNext(ImageSearchResponse imageSearchResponse) {
                if (mView != null) {
                    mView.showNextPage(imageSearchResponse.getData());
                }
            }
        });
    }

    private void loadImages(String query, int page, Observer<ImageSearchResponse> observer) {
        mService.search(query, page, Config.getDefaultLanguage())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
