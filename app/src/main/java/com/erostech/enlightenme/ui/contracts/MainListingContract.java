package com.erostech.enlightenme.ui.contracts;

import com.erostech.enlightenme.data.models.Image;

import java.util.List;

/**
 * Created by erosgarciaponte on 02/05/2017.
 */

public interface MainListingContract {
    interface View {
        void showInitialPage(List<Image> images, int totalImages);
        void showNextPage(List<Image> images);
        void showInitialPageError(Throwable throwable);
        void showNextPageError(Throwable throwable);
    }

    interface Presenter {
        void loadInitialPage(String query);
        void loadNextPage(String query, int page);
    }
}
