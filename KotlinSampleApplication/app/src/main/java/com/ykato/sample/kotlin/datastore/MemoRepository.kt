package com.ykato.sample.kotlin.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.concurrent.atomic.AtomicReference
import javax.inject.Inject
import javax.inject.Singleton

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "memo")
val MEMO_STRING = stringPreferencesKey("memo_string")

@Singleton
class MemoRepository @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    private val cache by lazy { AtomicReference<String?>(null) }

    init {
        GlobalScope.launch(Dispatchers.IO) {
            cache.compareAndSet("", observe().first())
        }
    }

    @Synchronized
    suspend fun save(memo: String) {
        context.dataStore.edit { preferences ->
            preferences[MEMO_STRING] = memo
        }
        cache.set(memo)
    }

    fun getCache(): String? = cache.get()

    fun observe() = context.dataStore.data.catch { exception ->
        if (exception is IOException) {
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { preferences ->
        preferences[MEMO_STRING] ?: ""
    }
}