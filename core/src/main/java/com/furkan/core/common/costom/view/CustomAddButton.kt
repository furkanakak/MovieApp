package com.furkan.core.common.costom.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.graphics.drawable.VectorDrawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.furkan.core.R

class CustomAddButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val mainGreenColor = ContextCompat.getColor(context, R.color.green)
    private val backgroundColor = ContextCompat.getColor(context, R.color.white)
    private val vectorDrawable = ContextCompat.getDrawable(context, R.drawable.ic_add) as VectorDrawable
    private val text = ContextCompat.getString(context, R.string.add)
    private var onClickListener : (() -> Unit)? =  null
    private val cornerRadius = 24f
    private val padding = 30f

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = mainGreenColor
        strokeWidth = 5f
        pathEffect = DashPathEffect(floatArrayOf(25f, 20f), 0f)
        style = Paint.Style.STROKE
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = mainGreenColor
        textSize = 50f
        typeface = Typeface.DEFAULT_BOLD
    }

    private var rectangle = RectF()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(backgroundColor)
        canvas.drawRoundRect(rectangle, cornerRadius, cornerRadius, paint)
        drawIconAndText(canvas)
    }

    private fun drawIconAndText(canvas: Canvas) {
        val textWidth = textPaint.measureText(text)
        val textHeight = textPaint.fontMetrics.run { descent - ascent }
        val totalWidth = textWidth + vectorDrawable.intrinsicWidth
        val centerX = rectangle.centerX() - totalWidth / 2

        vectorDrawable.setBounds(
            centerX.toInt(),
            rectangle.centerY().toInt() - vectorDrawable.intrinsicHeight / 2,
            (centerX + vectorDrawable.intrinsicWidth).toInt(),
            rectangle.centerY().toInt() + vectorDrawable.intrinsicHeight / 2
        )
        vectorDrawable.draw(canvas)

        canvas.drawText(
            text,
            centerX + vectorDrawable.intrinsicWidth,
            rectangle.centerY() + textHeight / 4,
            textPaint
        )
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        rectangle.set(padding, padding, width.toFloat() - padding, height.toFloat() - padding)
        setMeasuredDimension(width, height)
    }

    fun setOnClickListener(onClickListener: () -> Unit){
        this.onClickListener = onClickListener
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (rectangle.contains(event.x, event.y)) {
                    performClick()
                    onClickListener?.invoke()
                    return true
                }
            }
        }
        return super.onTouchEvent(event)
    }
}