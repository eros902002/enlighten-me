package com.erostech.enlightenme.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.erostech.enlightenme.R;
import com.erostech.enlightenme.callbacks.ImageListAdapterCallback;
import com.erostech.enlightenme.callbacks.LoadingViewHolderCallback;

/**
 * Created by erosgarciaponte on 02/05/2017.
 */

public class LoadingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ProgressBar mProgressBar;
    private ImageButton mRetryButton;
    private TextView mErrorText;
    private LinearLayout mErrorLayout;

    private ImageListAdapterCallback mCallback;
    private LoadingViewHolderCallback mRetryCallback;

    public LoadingViewHolder(View itemView) {
        super(itemView);
        mProgressBar = (ProgressBar) itemView.findViewById(R.id.load_more_progress);
        mRetryButton = (ImageButton) itemView.findViewById(R.id.load_more_retry);
        mErrorText = (TextView) itemView.findViewById(R.id.load_more_errortxt);
        mErrorLayout = (LinearLayout) itemView.findViewById(R.id.load_more_error_layout);

        mRetryButton.setOnClickListener(this);
        mErrorLayout.setOnClickListener(this);
    }

    public void bind(ImageListAdapterCallback callback, LoadingViewHolderCallback retryCallback, boolean retryPageLoad, String errorMessage) {
        this.mCallback = callback;
        this.mRetryCallback = retryCallback;
        if (retryPageLoad) {
            mErrorLayout.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.GONE);
            mErrorText.setText(errorMessage != null ? errorMessage : itemView.getContext().getString(R.string.error_msg_unknown));
        } else {
            mErrorLayout.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.load_more_retry:
            case R.id.load_more_error_layout:
                mRetryCallback.showRetry(false, null);
                mCallback.retryPageLoad();
                break;
        }
    }
}
