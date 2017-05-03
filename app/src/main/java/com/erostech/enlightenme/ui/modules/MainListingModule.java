package com.erostech.enlightenme.ui.modules;

import com.erostech.enlightenme.ui.contracts.MainListingContract;
import com.erostech.enlightenme.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by erosgarciaponte on 03/05/2017.
 */

@Module
public class MainListingModule {
    private final MainListingContract.View mView;

    public MainListingModule(MainListingContract.View view) {
        this.mView = view;
    }

    @Provides
    @CustomScope
    MainListingContract.View provideMainScreenContractView() {
        return mView;
    }

}
