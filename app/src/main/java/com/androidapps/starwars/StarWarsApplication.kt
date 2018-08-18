package com.androidapps.starwars

import android.app.Activity
import android.app.Application
import com.androidapps.starwars.dagger.utility.AppInjector
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by ankit on 8/11/18.
 */

class StarWarsApplication:Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        // Start dependency injection
        AppInjector.init(this)
        // Init Stetho
        Stetho.initializeWithDefaults(this);
    }
}