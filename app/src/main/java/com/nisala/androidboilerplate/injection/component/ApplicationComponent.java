package com.nisala.androidboilerplate.injection.component;

import android.app.Application;
import android.content.Context;

import com.nisala.androidboilerplate.data.DataManager;
import com.nisala.androidboilerplate.data.remote.ApiService;
import com.nisala.androidboilerplate.injection.ApplicationContext;
import com.nisala.androidboilerplate.injection.module.ApplicationModule;
import com.nisala.androidboilerplate.util.RxEventBus;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();
    Application application();
    ApiService apiService();
    DataManager dataManager();
    RxEventBus eventBus();

}
