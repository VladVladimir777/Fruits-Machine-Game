package com.example.code.fruitsmachinegame.di

import com.example.code.fruitsmachinegame.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun plusViewModelComponent(viewModelModule: ViewModelModule): ViewModelComponent

    fun inject(mainActivity: MainActivity)
}