package com.ykato.sample.kotlin.textview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ykato.sample.kotlin.R
import kotlinx.android.synthetic.main.list_adapter_item.view.*

class TextViewSampleAdapter(
        context: Context) : RecyclerView.Adapter<TextViewSampleAdapter.ListAdapterHolder>() {
    private val inflater = LayoutInflater.from(context)

    private val ID_NONE = 0
    private val ID_START = 1
    private val ID_MIDDLE = 2
    private val ID_END = 3
    private val ID_MARQUEE = 4
    private val ID_END_SMALL = 5
    private val ID_ARRAY = arrayOf(ID_NONE, ID_START, ID_MIDDLE, ID_END, ID_MARQUEE, ID_END_SMALL)

    class ListAdapterHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun getItemCount(): Int {
        return ID_ARRAY.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterHolder {
        val view = inflater.inflate(R.layout.list_adapter_item, parent, false)
        return ListAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: ListAdapterHolder, position: Int) {
        holder.itemView.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                if (position == ID_MARQUEE) holder.itemView.targetText.isSelected = true
            } else {
                if (position == ID_MARQUEE) holder.itemView.targetText.isSelected = false
            }
        }
        when (position) {
            ID_NONE -> setEllipsize(holder, "ellipsize NONE", null)
            ID_START -> setEllipsize(holder, "ellipsize START", TextUtils.TruncateAt.START)
            ID_MIDDLE -> setEllipsize(holder, "ellipsize MIDDLE", TextUtils.TruncateAt.MIDDLE)
            ID_END -> setEllipsize(holder, "ellipsize END", TextUtils.TruncateAt.END)
            ID_MARQUEE -> setEllipsize(holder, "ellipsize MARQUEE", TextUtils.TruncateAt.MARQUEE)
            else -> setEllipsize(holder, "ellipsize END_SMALL", TextUtils.TruncateAt.END_SMALL)
        }
    }

    private fun setEllipsize(holder: ListAdapterHolder, text: String, where: TextUtils.TruncateAt?) {
        holder.itemView.ellipsize.setText(text)
        holder.itemView.targetText.ellipsize = where
    }
}