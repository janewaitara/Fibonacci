package com.mumbicodes.fibonacci.data.repository

import com.mumbicodes.fibonacci.data.db.FibonacciDao
import com.mumbicodes.fibonacci.domain.model.FibonacciSearch
import com.mumbicodes.fibonacci.domain.repository.FibonacciRepository
import kotlinx.coroutines.flow.Flow

class FibonacciRepositoryImpl(private val fibonacciDao: FibonacciDao) : FibonacciRepository {
    override suspend fun insertFibonacciNumber(fibonacciSearch: FibonacciSearch) {
        fibonacciDao.insertFibonacciNumber(fibonacciSearch)
    }

    override fun getFibonacciNumbers(): Flow<List<FibonacciSearch>> =
        fibonacciDao.getFibonacciNumbers()

    override suspend fun deleteFibonacciNumber(fibonacciId: Int) {
        fibonacciDao.deleteFibonacci(fibonacciId)
    }

    override suspend fun deleteAllFibonacciNumbers() {
        fibonacciDao.deleteAllFibonacciNumbers()
    }
}
