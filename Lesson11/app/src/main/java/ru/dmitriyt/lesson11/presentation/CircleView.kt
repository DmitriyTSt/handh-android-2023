package ru.dmitriyt.lesson11.presentation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import ru.dmitriyt.lesson11.R

class CircleView : View {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)

    private val startRadius by lazy { resources.getDimension(R.dimen.circle_radius_start) }
    private val endRadius by lazy { resources.getDimension(R.dimen.circle_radius_end) }
    private var radius: Float = 0f
    private val circleStrokeWidth by lazy { resources.getDimension(R.dimen.circle_stroke_width) }
    private var valueAnimator: ValueAnimator? = null
    private var objectAnimator: ObjectAnimator? = null
    private var animatorSet: AnimatorSet? = null

    private val paint by lazy {
        Paint().apply {
            color = Color.GREEN
            style = Paint.Style.STROKE
            strokeWidth = circleStrokeWidth
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val centerX = width / 2
        val centerY = height / 2

        canvas.drawOval(
            centerX - radius,
            centerY - radius,
            centerX + radius,
            centerY + radius,
            paint,
        )
    }

    fun startAnimation() {
        val valueAnimator = ValueAnimator.ofFloat(startRadius, endRadius, startRadius).apply {
            duration = 2000
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                val animatedRadius = it.animatedValue as Float
                radius = animatedRadius
                invalidate()
            }
        }
//        valueAnimator?.start()
        val objectAnimator = ObjectAnimator.ofFloat(this, "translationY", 0f, 400f, 0f).apply {
            duration = 2000
            repeatCount = ValueAnimator.INFINITE
        }
//        objectAnimator?.start()
        animatorSet = AnimatorSet()
        animatorSet?.play(valueAnimator)?.with(objectAnimator)
        animatorSet?.start()
    }

    fun stopAnimation() {
        animatorSet?.cancel()
//        valueAnimator?.cancel()
//        objectAnimator?.cancel()
    }
}