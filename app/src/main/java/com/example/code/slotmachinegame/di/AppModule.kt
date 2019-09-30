package com.example.code.slotmachinegame.di

import android.content.Context
import com.example.code.slotmachinegame.settingsGame.SettingsGame
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