package com.mumbicodes.fibonacci.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mumbicodes.fibonacci.domain.model.FibonacciSearch

@Database(
    entities = [FibonacciSearch::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListConverter::class)
abstract class FibonacciDatabase : RoomDatabase() {
    abstract fun fibonacciNumbersDao(): FibonacciDao
}
