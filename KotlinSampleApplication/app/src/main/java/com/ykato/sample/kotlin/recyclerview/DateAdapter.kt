package com.ykato.sample.kotlin.recyclerview

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.LinearLayout
import com.ykato.sample.kotlin.recyclerview.CalenderItemView.Companion.ITEM_HEIGHT

class DateAdapter : RecyclerView.Adapter<DateAdapter.DateAdapterHolder>() {
    companion object {
        private const val ITEM_COUNT = 700
        private const val UPDATE_POSITION = 14
    }
    private val dateInfoUtil = DateInfoUtil()
    private var dateInfoList = dateInfoUtil.createDateInfoList()

    class DateAdapterHolder(view: CalenderItemView) : RecyclerView.ViewHolder(view) {
        var year: String = ""
        var month: String = ""
        var isFirstWeek = false
    }

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateAdapterHolder {
        return DateAdapterHolder(
                CalenderItemView(parent.context).apply {
                    layoutParams = LinearLayout.LayoutParams(parent.width / 7, ITEM_HEIGHT.toInt())
                }
        )
    }

    override fun onBindViewHolder(holder: DateAdapterHolder, position: Int) {
        val dateInfo = dateInfoList[position]
        holder.year = dateInfo.year.toString()
        holder.month = dateInfo.month.toString()
        val day = dateInfo.day
        with(holder.itemView as CalenderItemView) {
            date = if (day == 0) "" else day.toString()
            color = dateInfo.textColor
        }
        holder.isFirstWeek = dateInfo.isFirstWeek

        if (dateInfoUtil.getDateInfoSize() - position < UPDATE_POSITION) {
            addDateInfo()
        }
    }

    private fun addDateInfo() {
        dateInfoUtil.addDateInfo()
        dateInfoList = dateInfoUtil.createDateInfoList()
    }
}
