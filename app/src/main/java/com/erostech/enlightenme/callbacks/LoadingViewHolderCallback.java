package com.erostech.enlightenme.callbacks;

import android.support.annotation.Nullable;

/**
 * Created by erosgarciaponte on 02/05/2017.
 */

public interface LoadingViewHolderCallback {
    void showRetry(boolean show, @Nullable String errorMessage);
}
