package com.nisala.androidboilerplate.injection.component;

import com.nisala.androidboilerplate.injection.PerActivity;
import com.nisala.androidboilerplate.injection.module.ActivityModule;
import com.nisala.androidboilerplate.login.LoginActivity;

import dagger.Subcomponent;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginActivity loginActivity);
}
