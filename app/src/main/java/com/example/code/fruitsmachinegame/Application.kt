package com.example.code.fruitsmachinegame

import androidx.multidex.MultiDexApplication
import com.example.code.fruitsmachinegame.di.*

class Application : MultiDexApplication() {

    lateinit var appComponent: AppComponent
    lateinit var viewModelComponent: ViewModelComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        viewModelComponent = appComponent.plusViewModelComponent(ViewModelModule())

    }

}