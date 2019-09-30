package com.example.code.fruitsmachinegame.di

import com.example.code.fruitsmachinegame.fragmentGame.VMGameFragment
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
@ViewModelScope
interface ViewModelComponent {

    fun inject(vmGameFragment: VMGameFragment)

}