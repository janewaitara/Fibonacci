package com.mumbicodes.fibonacci.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@ProvidedTypeConverter
class ListConverter {
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val resultsType = Types.newParameterizedType(List::class.java, Int::class.java)
    private val resultsAdapter = moshi.adapter<List<Int>>(resultsType)

    @TypeConverter
    fun fromStringToResults(value: String): List<Int> =
        resultsAdapter.fromJson(value)!!

    @TypeConverter
    fun fromResultsToString(results: List<Int>): String =
        resultsAdapter.toJson(results)
}
