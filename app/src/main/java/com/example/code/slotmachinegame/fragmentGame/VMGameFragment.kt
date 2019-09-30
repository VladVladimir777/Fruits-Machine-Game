package com.example.code.slotmachinegame.fragmentGame

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.code.slotmachinegame.settingsGame.SettingsGame
import javax.inject.Inject

class VMGameFragment(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var settingsGame: SettingsGame
    private var data = MutableLiveData<Int>()

    init {
        (application as com.example.code.slotmachinegame.Application)
            .viewModelComponent.inject(this)
    }


    fun getData(): MutableLiveData<Int> {
        return data
    }


    fun onStart() {
        data.postValue(settingsGame.coins)
    }


    fun saveCoins(coins: Int) {
        settingsGame.coins += coins
        data.postValue(settingsGame.coins)
    }

}