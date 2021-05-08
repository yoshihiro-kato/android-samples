package com.ykato.sample.kotlin.recyclerview

import android.graphics.Color
import java.time.DayOfWeek
import java.time.LocalDate

class DateInfoUtil {
    companion object {
        private const val ADDITIONAL_COUNT_WEEK = 15
    }
    private var localDate = LocalDate.of(LocalDate.now().year, LocalDate.now().month,1)
    private var dateInfoList = ArrayList<DateInfo>()
    private val dayOfWeekArray = arrayOf(DayOfWeek.SUNDAY,DayOfWeek.MONDAY,DayOfWeek.TUESDAY,DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,DayOfWeek.FRIDAY,DayOfWeek.SATURDAY)

    init {
        for (i in dayOfWeekArray) {
            val dateInfo = DateInfo(
                    year = localDate.year,
                    month = localDate.month
            )
            if (i == localDate.dayOfWeek) {
                dateInfo.day = localDate.dayOfMonth
                dateInfo.textColor = when(i) {
                    DayOfWeek.SUNDAY -> Color.RED
                    DayOfWeek.SATURDAY -> Color.BLUE
                    else -> Color.BLACK
                }
                localDate = localDate.plusDays(1.toLong())
            }
            dateInfo.isFirstWeek = true
            dateInfoList.add(dateInfo)
        }
    }

    fun createDateInfoList() : ArrayList<DateInfo> {
        addDateInfo(dateInfoList)
        return dateInfoList
    }

    fun getDateInfoSize() : Int {
        return dateInfoList.size
    }

    fun addDateInfo() {
        addDateInfo(dateInfoList)
    }

    private fun addDateInfo(calenderStr : ArrayList<DateInfo>) {
        for (i in 1..ADDITIONAL_COUNT_WEEK) {
            val dateInfoList = mutableListOf<DateInfo>()
            var isFirstWeek = false
            for (j in dayOfWeekArray) {
                if (localDate.dayOfMonth == 1) {
                    isFirstWeek = true
                    addEmptyDay(j, dateInfoList)
                }
                val dateInfo = DateInfo(
                        year = localDate.year,
                        month = localDate.month,
                        day = localDate.dayOfMonth
                )
                dateInfo.textColor = when(j) {
                    DayOfWeek.SUNDAY -> Color.RED
                    DayOfWeek.SATURDAY -> Color.BLUE
                    else -> Color.BLACK
                }
                if (isFirstWeek) dateInfo.isFirstWeek = true
                dateInfoList.add(dateInfo)
                localDate = localDate.plusDays(1.toLong())
            }
            calenderStr.addAll(dateInfoList)
        }
    }

    private fun addEmptyDay(j: DayOfWeek, dateInfoList: MutableList<DateInfo>) {
        if (j != DayOfWeek.SUNDAY) {
            for (k in 0..6) {
                val dateInfo = DateInfo(
                        year = localDate.year,
                        month = localDate.month
                )
                if (k >= 7 - dayOfWeekArray.indexOf(j)) dateInfo.isFirstWeek = true
                dateInfoList.add(dateInfo)
            }
        }
    }
}
