package com.example.code.fruitsmachinegame.settingsGame

import android.content.Context
import com.orhanobut.hawk.Hawk

class SettingsGame(context: Context) {

    init {
        Hawk.init(context).build()
    }

    var coins: Int
        get() = Hawk.get(SETTING_KEY_COINS, 0)
        set(value) {
            Hawk.put(SETTING_KEY_COINS, value)
        }



}