package com.nisala.androidboilerplate.injection.module;

/**
 * Created by nisala on 12,October,2018
 */

import android.app.Application;
import android.content.Context;

import com.nisala.androidboilerplate.data.remote.ApiService;
import com.nisala.androidboilerplate.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide application-level dependencies.
 */

@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    ApiService provideAtoService() {
        return ApiService.Creator.newApiService();
    }

}