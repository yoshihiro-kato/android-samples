package com.ykato.sample.kotlin.recyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.ykato.sample.kotlin.R

class DateAdapter (
    context: Context) : RecyclerView.Adapter<DateAdapter.DateAdapterHolder>() {
    companion object {
        private const val ITEM_COUNT = 700
        private const val UPDATE_POSITION = 14
    }
    private val inflater = LayoutInflater.from(context)
    private val dateInfoUtil = DateInfoUtil()
    private var dateInfoList = dateInfoUtil.createDateInfoList()

    class DateAdapterHolder(view: View) : RecyclerView.ViewHolder(view) {
        var year: String = ""
        var month: String = ""
        var day: TextView = view.findViewById(R.id.day)
        var isBeginningOfMonth = false
    }

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateAdapterHolder {
        val view = inflater.inflate(R.layout.calendar_item, parent, false)
        return DateAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: DateAdapterHolder, position: Int) {
        val dateInfo = dateInfoList[position]
        holder.year = dateInfo.year.toString()
        holder.month = dateInfo.month.toString()
        val day = dateInfo.day
        holder.day.text = if (day == 0) "" else day.toString()
        holder.day.setTextColor(dateInfo.textColor)
        holder.isBeginningOfMonth = dateInfo.isFirstWeek

        if (dateInfoUtil.getDateInfoSize() - position < UPDATE_POSITION) {
            addDateInfo()
        }
    }

    private fun addDateInfo() {
        dateInfoUtil.addDateInfo()
        dateInfoList = dateInfoUtil.createDateInfoList()
    }
}
