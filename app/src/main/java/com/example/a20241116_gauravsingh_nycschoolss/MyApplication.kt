package com.example.a20241116_gauravsingh_nycschoolss

import android.app.Application
import com.example.a20241116_gauravsingh_nycschoolss.di.ApplicationComponent
import com.example.a20241116_gauravsingh_nycschoolss.di.DaggerApplicationComponent


class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}