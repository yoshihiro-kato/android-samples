package com.ykato.sample.kotlin.recyclerview

import android.graphics.Color
import java.time.Month

data class DateInfo(
        var year: Int = 0,
        var month: Month? = null,
        var day: Int = 0,
        var textColor: Int = Color.BLACK,
        var isFirstWeek: Boolean = false
)