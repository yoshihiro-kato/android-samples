package com.ykato.sample.kotlin.datastore

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MemoViewModel(application: Application): AndroidViewModel(application) {
    private val store = MemoRepository(application)
    val text = MutableLiveData("")

    init {
        viewModelScope.launch {
            text.value = store.observe().first()
        }
    }

    fun onClick() {
        GlobalScope.launch(Dispatchers.IO) {
            store.save(text.value!!)
        }
    }
}