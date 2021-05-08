package com.ykato.sample.kotlin.recyclerview

import android.graphics.*
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class DateItemDecoration: RecyclerView.ItemDecoration() {
    companion object {
        private const val HEADER_HEIGHT = 100
        private val headerBackGroundPaint = Paint().apply {
            color = Color.GRAY
            alpha = 200
        }
        private val headerTextPaint = Paint().apply {
            textSize = 65f
            color = Color.WHITE
        }
    }

    override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if ((parent.getChildViewHolder(view) as DateAdapter.DateAdapterHolder).isFirstWeek) {
            outRect.top = HEADER_HEIGHT
        } else {
            outRect.top = 0
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val size = state.itemCount
        for (i in 0 until size step 7) {
            drawHeader(parent, c, i, i + 7)
        }
    }

    private fun drawHeader(parent: RecyclerView, c: Canvas, prev: Int, now: Int) {
        val prevView = parent.getChildAt(prev)
        val prevHolder =
                if (prevView == null) {
                    return
                } else {
                    parent.getChildViewHolder(prevView) as DateAdapter.DateAdapterHolder
                }
        if (prevHolder.isFirstWeek) {
            c.drawRect(
                    0f,
                    prevView.y - HEADER_HEIGHT,
                    parent.width.toFloat(),
                    prevView.y,
                    headerBackGroundPaint
            )
            c.drawText(
                    "${prevHolder.month} ${prevHolder.year}",
                    0f,
                    prevView.y,
                    headerTextPaint
            )
        }
    }
}