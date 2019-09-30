package com.example.code.fruitsmachinegame.appComponents.appAbstractTypes

import androidx.appcompat.app.AppCompatActivity
import com.example.code.fruitsmachinegame.appComponents.appCallbacks.FragmentsCallback
import com.example.code.fruitsmachinegame.appComponents.appCallbacks.ToolbarCallback

abstract class AbstractActivity : AppCompatActivity() {

    protected lateinit var fragmentCallback: FragmentsCallback
    protected lateinit var toolbarCallback: ToolbarCallback


    override fun onResume() {
        super.onResume()
        fragmentCallback = this as FragmentsCallback
        toolbarCallback = this as ToolbarCallback
    }
}