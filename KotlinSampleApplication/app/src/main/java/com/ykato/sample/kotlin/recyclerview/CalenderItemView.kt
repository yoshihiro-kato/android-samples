package com.ykato.sample.kotlin.recyclerview

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.util.TypedValue.applyDimension
import android.view.Gravity
import android.widget.LinearLayout

private val Float.sp get() =
    applyDimension(TypedValue.COMPLEX_UNIT_SP, this, Resources.getSystem().displayMetrics)

class CalenderItemView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {
    companion object {
        private val TEXT_SIZE = 20f.sp
        private val MARGIN_SIZE = 5f.sp
        val ITEM_HEIGHT = TEXT_SIZE + MARGIN_SIZE * 2
        private val textPaint = Paint().apply {
            textSize = TEXT_SIZE
        }
    }

    var date: String = ""
    var color: Int = Color.BLACK

    init {
        gravity = Gravity.RIGHT
        setBackgroundColor(Color.WHITE)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        textPaint.color = color
        canvas?.drawText(
                date,
                if (date.length == 1) TEXT_SIZE / 2 else 0f.sp,
                TEXT_SIZE + MARGIN_SIZE,
                textPaint
        )
    }
}