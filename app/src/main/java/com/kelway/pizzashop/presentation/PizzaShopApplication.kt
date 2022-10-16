package com.kelway.pizzashop.presentation

import android.app.Application
import com.kelway.pizzashop.AppComponent
import com.kelway.pizzashop.DaggerAppComponent

class PizzaShopApplication : Application() {
    companion object {
        var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .buildContext(this)
            .build()
    }
}