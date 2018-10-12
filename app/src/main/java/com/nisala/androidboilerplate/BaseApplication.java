package com.nisala.androidboilerplate;

import android.app.Application;
import android.content.Context;

import com.nisala.androidboilerplate.injection.component.ApplicationComponent;
import com.nisala.androidboilerplate.injection.component.DaggerApplicationComponent;
import com.nisala.androidboilerplate.injection.module.ApplicationModule;

import timber.log.Timber;

/**
 * Created by nisala on 12,October,2018
 */
public class BaseApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
