package com.github.fajaragungpramana.viewprocess

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.core.graphics.drawable.DrawableCompat

class ViewProcess @JvmOverloads constructor(
    ctx: Context,
    attrs: AttributeSet?,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(ctx, attrs, defStyle, defStyleRes) {

    private var mView: View? = null
        set(value) {
            field = value

            field.let {
                mViewProcess = findViewById(R.id.cv_view_process)
                mViewAnimate = findViewById(R.id.v_view_animate)
            }
        }

    private lateinit var mViewProcess: CardView
    private lateinit var mViewAnimate: View

    private lateinit var mFocusListener: FocusListener

    val start: Boolean
        get() {
            visibility = View.VISIBLE

            setFocusListener(object : FocusListener {

                override fun onWindowFocus(width: Float) {
                    mViewAnimate.let {
                        it.translationX = 0F - width
                        it.animate()
                            .translationX(width * 2)
                            .setDuration(800)
                            .setUpdateListener {  valueAnimator ->
                                valueAnimator.repeatCount = Animation.INFINITE
                            }
                            .start()
                    }
                }

            })

            return true
        }

    val stop: Unit
        get() {
            visibility = View.GONE
            mViewAnimate.animate().setUpdateListener { it.repeatCount = Animation.RESTART }

            return
        }

    var color: Int = 0
        set(value) {
            field = value

            if (field != 0) DrawableCompat.setTint(mViewProcess.background, field)
        }

    var radius: Float = 0F
        set(value) {
            field = value

            if (field != 0F) mViewProcess.radius = field / 2F
        }

    init {
        mView = LayoutInflater.from(ctx).inflate(R.layout.view_process, this, true)

        val ta = ctx.obtainStyledAttributes(attrs, R.styleable.ViewProcess, defStyle, defStyleRes)
        ta.let {
            color = it.getColor(R.styleable.ViewProcess_color, 0)
            radius = it.getDimension(R.styleable.ViewProcess_radius, 0F)
        }

        ta.recycle()
    }

    override fun onWindowFocusChanged(hasWindowFocus: Boolean) {
        super.onWindowFocusChanged(hasWindowFocus)

        mViewAnimate.let {
            it.layoutParams.let { param ->
                param.width = (50 * width) / 100
                param.height = height * 2
            }
            it.translationY = -((50F * height) / 100F)
            it.rotation = 30F
            it.requestLayout()
        }

        mFocusListener.onWindowFocus(width.toFloat())
    }

    private fun setFocusListener(focusListener: FocusListener) {
        mFocusListener = focusListener
    }

}