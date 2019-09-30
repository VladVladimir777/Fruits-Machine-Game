package com.example.code.fruitsmachinegame.di

import android.content.Context
import com.example.code.fruitsmachinegame.settingsGame.SettingsGame
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(context: Context) {

    private val settingsGame = SettingsGame(context)


    @Provides
    @Singleton
    fun provideSettingsGame(): SettingsGame {
        return settingsGame
    }

}