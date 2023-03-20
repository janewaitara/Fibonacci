package com.mumbicodes.fibonacci.domain.repository

import com.mumbicodes.fibonacci.domain.model.FibonacciSearch
import kotlinx.coroutines.flow.Flow

interface FibonacciRepository {
    suspend fun insertFibonacciNumber(fibonacciSearch: FibonacciSearch)

    fun getFibonacciNumbers(): Flow<List<FibonacciSearch>>

    suspend fun deleteFibonacciNumber(fibonacciId: Int)

    suspend fun deleteAllFibonacciNumbers()
}
