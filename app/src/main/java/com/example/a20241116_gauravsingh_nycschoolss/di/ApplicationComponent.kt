package com.example.a20241116_gauravsingh_nycschoolss.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.a20241116_gauravsingh_nycschoolss.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class,ViewModelModule::class])
interface ApplicationComponent {

fun inject(mainActivity: MainActivity)

fun getMap(): Map<Class<*>, ViewModel>

@Component.Factory
interface Factory {
    fun create(@BindsInstance context: Context): ApplicationComponent
}

}