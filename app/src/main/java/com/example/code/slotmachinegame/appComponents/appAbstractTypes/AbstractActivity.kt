package com.example.code.slotmachinegame.appComponents.appAbstractTypes

import androidx.appcompat.app.AppCompatActivity
import com.example.code.slotmachinegame.appComponents.appCallbacks.FragmentsCallback
import com.example.code.slotmachinegame.appComponents.appCallbacks.ToolbarCallback

abstract class AbstractActivity : AppCompatActivity() {

    protected lateinit var fragmentCallback: FragmentsCallback
    protected lateinit var toolbarCallback: ToolbarCallback


    override fun onResume() {
        super.onResume()
        fragmentCallback = this as FragmentsCallback
        toolbarCallback = this as ToolbarCallback
    }
}