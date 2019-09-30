package com.example.code.slotmachinegame.customView

import android.animation.Animator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.code.slotmachinegame.R
import com.example.code.slotmachinegame.fragmentGame.*
import kotlinx.android.synthetic.main.image_view_slot.view.*

class ImageViewSlot : ConstraintLayout {

    private var lastResult = 0
    private var oldValue = 0
    var eventEnd: EventEnd? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    companion object {
        private const val ANIM_DURATION = 150L
    }


    init {
        LayoutInflater.from(context).inflate(R.layout.image_view_slot, this, true)
        imgNext.translationY = measuredHeight.toFloat()
    }


    fun setValueRandom(image: Int, rotateCount: Int) {
        imgCurrent.animate().translationY(-measuredHeight.toFloat()).setDuration(ANIM_DURATION)
            .start()
        imgNext.translationY = imgNext.measuredHeight.toFloat()
        imgNext.animate().translationY(0F).setDuration(ANIM_DURATION).setListener(
            object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    setImage(imgCurrent, oldValue % 6)
                    imgCurrent.translationY = 0F
                    if (oldValue != rotateCount) {
                        setValueRandom(image, rotateCount)
                        oldValue++
                    } else {
                        lastResult = 0
                        oldValue = 0
                        setImage(imgNext, image)
                        eventEnd?.event(image % 6, rotateCount)
                    }

                }

                override fun onAnimationCancel(animation: Animator?) {

                }

                override fun onAnimationStart(animation: Animator?) {

                }

            }
        )

    }


    private fun setImage(imageView: ImageView, value: Int) {
        when (value) {
            APPLE -> imageView.setImageResource(R.drawable.img_apple)
            KIWI -> imageView.setImageResource(R.drawable.img_kiwi)
            LEMON -> imageView.setImageResource(R.drawable.img_lemon)
            MANGO -> imageView.setImageResource(R.drawable.img_mango)
            PAPAYA -> imageView.setImageResource(R.drawable.img_papaya)
            else -> imageView.setImageResource(R.drawable.img_pomegranate)
        }
        imageView.tag = value
        lastResult = value
    }


    fun getValue(): Any = imgNext.tag


    interface EventEnd {
        fun event(result: Int, count: Int)
    }

}