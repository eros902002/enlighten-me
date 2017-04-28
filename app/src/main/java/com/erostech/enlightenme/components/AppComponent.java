package com.erostech.enlightenme.components;

import com.erostech.enlightenme.modules.AppModule;
import com.erostech.enlightenme.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by erosgarciaponte on 28/04/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {
    Retrofit retrofit();
}
