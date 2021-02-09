package com.github.fajaragungpramana.viewprocess

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat

class ViewProcess(context: Context, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    private val mPlat: View
        get() {
            field.background = ContextCompat.getDrawable(context, R.drawable.bg_plat)

            return field
        }

    private val viewProcessColor: Int

    private val viewProcessRadius: Float

    val start: Unit
        get() {
            removeView(mPlat)
            addView(mPlat, (40 * width) / 100, LayoutParams.MATCH_PARENT)

            mPlat.let {
                it.translationX = 0F - width
                it.scaleY = height * 2F
                it.rotation = 40F
            }

            mPlat.animate()
                .translationX(width * 2F)
                .setDuration(700)
                .setUpdateListener { it.repeatCount = Animation.INFINITE }
                .start()
        }

    val stop: Unit
        get() {
            removeView(mPlat)

            mPlat.translationX = 0F - width
            mPlat.animate().cancel()
        }

    init {
        mPlat = View(context)

        context.obtainStyledAttributes(attrs, R.styleable.ViewProcess).also {
            viewProcessColor = it.getColor(R.styleable.ViewProcess_viewProcessColor, Color.parseColor("#EBEBEB"))
            viewProcessRadius = it.getDimension(R.styleable.ViewProcess_viewProcessRadius, 0F)
        }.recycle()

        View(context).also {
            it.background = ContextCompat.getDrawable(context, R.drawable.bg_main)
            (it.background as GradientDrawable).let { bg ->
                bg.setColor(viewProcessColor)
                bg.cornerRadius = viewProcessRadius
            }
            addView(it)
        }
    }

}