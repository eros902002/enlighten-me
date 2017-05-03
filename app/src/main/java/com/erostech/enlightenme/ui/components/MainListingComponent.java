package com.erostech.enlightenme.ui.components;

import com.erostech.enlightenme.components.AppComponent;
import com.erostech.enlightenme.ui.fragments.MainListingFragment;
import com.erostech.enlightenme.ui.modules.MainListingModule;
import com.erostech.enlightenme.util.CustomScope;

import dagger.Component;

/**
 * Created by erosgarciaponte on 03/05/2017.
 */

@CustomScope
@Component(dependencies = AppComponent.class, modules = MainListingModule.class)
public interface MainListingComponent {
    void inject(MainListingFragment fragment);
}
