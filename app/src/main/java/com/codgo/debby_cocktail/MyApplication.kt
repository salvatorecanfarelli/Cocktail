package com.codgo.debby_cocktail

import android.app.Application
import android.content.Context
import com.codgo.debby_cocktail.utilities.AdapterRest
import com.codgo.debby_cocktail.utilities.SharedPreferences

class MyApplication : Application() {

    var context : Context? = null
    override fun onCreate() {
        super.onCreate()
        context = this
        AdapterRest.init()
        SharedPreferences.init(context as MyApplication)
    }
}