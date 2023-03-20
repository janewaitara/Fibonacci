package com.mumbicodes.fibonacci.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fibonacci_table")
data class FibonacciSearch(
    @PrimaryKey(autoGenerate = true)
    var fibonacciId: Int = 0,
    var searchedNumber: Long,
    var fibResult: List<Int>,
    var timeSearched: Long,
)
