package com.example.code.fruitsmachinegame.fragmentGame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.code.fruitsmachinegame.R
import com.example.code.fruitsmachinegame.appComponents.appAbstractTypes.AbstractFragment
import com.example.code.fruitsmachinegame.customView.ImageViewSlot
import kotlinx.android.synthetic.main.fragment_game.*
import java.util.*

class GameFragment : AbstractFragment(), ImageViewSlot.EventEnd {

    companion object {
        const val FRAGMENT_GAME = "gameFragment"
    }

    private lateinit var viewModel: VMGameFragment
    private lateinit var liveData: LiveData<Int>
    private lateinit var slots: Array<ImageViewSlot>
    private var countDownSlots = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(VMGameFragment::class.java)
        liveData = viewModel.getData()
        liveData.observe(this, Observer<Int> {
            toolbarCallback.viewCoins(it)

        })
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        slots = arrayOf(slot1, slot2, slot3)
        slots.forEach { it.eventEnd = this }

        btnStart.setOnClickListener {
            slots.forEach {
                it.setValueRandom(
                    Random().nextInt(COUNT_FRUITS),
                    Random().nextInt((15 - 5) + 1) + 5
                )
            }

            btnStart.isClickable = false

        }

    }


    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }


    override fun event(result: Int, count: Int) {
        if (countDownSlots < 2) {
            countDownSlots++
        } else {
            btnStart.isClickable = true

            if (slots[0].getValue() == slots[1].getValue() &&
                slots[1].getValue() == slots[2].getValue()
            ) {
                viewModel.saveCoins(COINS_LUCKY)
                Toast.makeText(requireContext(), R.string.message_lucky, Toast.LENGTH_SHORT).show()
            } else if (slots[0].getValue() == slots[1].getValue() ||
                slots[1].getValue() == slots[2].getValue() ||
                slots[0].getValue() == slots[2].getValue()
            ) {
                viewModel.saveCoins(COINS_WIN)
                Toast.makeText(requireContext(), R.string.message_win, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), R.string.message_lose, Toast.LENGTH_SHORT).show()
            }
            countDownSlots = 0
        }
    }


}