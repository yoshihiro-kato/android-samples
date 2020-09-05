package com.ykato.sample.kotlin.recyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.ykato.sample.kotlin.R

class DateAdapter (
    context: Context) : androidx.recyclerview.widget.RecyclerView.Adapter<DateAdapter.DateAdapterHolder>() {
    private val ITEM_COUNT = 700
    private val UPDATE_POSITION = 14
    private val inflater = LayoutInflater.from(context)
    private val dateInfoUtil = DateInfoUtil()
    private var dateInfoList = dateInfoUtil.createDateInfoList()

    class DateAdapterHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        var date = view.findViewById<TextView>(R.id.date)
    }

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateAdapterHolder {
        val view = inflater.inflate(R.layout.calendar_item, parent, false)
        return DateAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: DateAdapterHolder, position: Int) {
        holder.date.text = dateInfoList[position].dateString
        holder.date.setTextColor(dateInfoList[position].textColor)

        if (dateInfoUtil.getDateInfoSize() - position < UPDATE_POSITION) {
            addDateInfo()
        }
    }

    private fun addDateInfo() {
        dateInfoUtil.addDateInfo()
        dateInfoList = dateInfoUtil.createDateInfoList()
    }
}
