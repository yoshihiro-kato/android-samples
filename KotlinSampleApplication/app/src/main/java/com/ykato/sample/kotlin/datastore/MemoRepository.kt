package com.ykato.sample.kotlin.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "memo")
val MEMO_STRING = stringPreferencesKey("memo_string")

class MemoRepository @Inject constructor(
    @ApplicationContext private val context: Context,
) {

    suspend fun save(memo: String) {
        context.dataStore.edit { preferences ->
            preferences[MEMO_STRING] = memo
        }
    }

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