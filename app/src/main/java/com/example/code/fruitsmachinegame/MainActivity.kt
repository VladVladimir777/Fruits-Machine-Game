package com.example.code.fruitsmachinegame

import android.os.Bundle
import android.view.WindowManager
import com.example.code.fruitsmachinegame.appComponents.appAbstractTypes.AbstractActivity
import com.example.code.fruitsmachinegame.appComponents.appCallbacks.FragmentsCallback
import com.example.code.fruitsmachinegame.appComponents.appCallbacks.ToolbarCallback
import com.example.code.fruitsmachinegame.fragmentGame.GameFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbstractActivity(), FragmentsCallback, ToolbarCallback {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setFragment(GameFragment.FRAGMENT_GAME)

    }


    override fun setFragment(key: String) {
        val frTransaction = supportFragmentManager.beginTransaction()
        frTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
        when (key) {
            GameFragment.FRAGMENT_GAME ->
                if (supportFragmentManager.findFragmentById(R.id.flMain) !is GameFragment) {
                    frTransaction.replace(R.id.flMain, GameFragment())
                }
        }

        frTransaction.commit()
    }


    override fun viewCoins(coins: Int) {
        tvToolbarCoins.text = coins.toString()
    }
}
