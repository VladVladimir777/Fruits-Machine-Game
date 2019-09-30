package com.example.code.slotmachinegame.di

import com.example.code.slotmachinegame.fragmentGame.VMGameFragment
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
@ViewModelScope
interface ViewModelComponent {

    fun inject(vmGameFragment: VMGameFragment)

}