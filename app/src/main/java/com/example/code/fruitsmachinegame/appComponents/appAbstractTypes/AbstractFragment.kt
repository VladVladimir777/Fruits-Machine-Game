package com.example.code.fruitsmachinegame.appComponents.appAbstractTypes

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.code.fruitsmachinegame.appComponents.appCallbacks.FragmentsCallback
import com.example.code.fruitsmachinegame.appComponents.appCallbacks.ToolbarCallback

abstract class AbstractFragment : Fragment() {

    protected lateinit var fragmentCallback: FragmentsCallback
    protected lateinit var toolbarCallback: ToolbarCallback


    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentCallback = activity as FragmentsCallback
        toolbarCallback = activity as ToolbarCallback
    }

}