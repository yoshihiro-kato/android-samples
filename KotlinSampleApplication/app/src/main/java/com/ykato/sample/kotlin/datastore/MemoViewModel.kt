package com.ykato.sample.kotlin.datastore

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemoViewModel @Inject constructor(
    private val store: MemoRepository
): ViewModel() {
    val text = MutableLiveData(store.getCache())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            text.postValue(store.observe().first())
        }
    }

    fun onClick() {
        GlobalScope.launch(Dispatchers.IO) {
            store.save(text.value ?: "")
        }
    }
}