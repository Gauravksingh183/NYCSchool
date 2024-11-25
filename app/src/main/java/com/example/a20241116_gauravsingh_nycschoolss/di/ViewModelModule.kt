package com.example.a20241116_gauravsingh_nycschoolss.di

import androidx.lifecycle.ViewModel
import com.example.a20241116_gauravsingh_nycschoolss.viewmodel.MainViewModel
import com.otherTallguy.dagger2example.viewmodel.MainViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @ClassKey(MainViewModel2::class)
    @IntoMap
    abstract fun mainViewModel2(mainViewModel2: MainViewModel2): ViewModel

}