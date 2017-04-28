package com.erostech.enlightenme;

import android.app.Application;

import com.erostech.enlightenme.components.AppComponent;
import com.erostech.enlightenme.components.DaggerAppComponent;
import com.erostech.enlightenme.config.Config;
import com.erostech.enlightenme.modules.AppModule;
import com.erostech.enlightenme.modules.NetModule;

/**
 * Created by erosgarciaponte on 28/04/2017.
 */

public class App extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(Config.getApiUrl()))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
