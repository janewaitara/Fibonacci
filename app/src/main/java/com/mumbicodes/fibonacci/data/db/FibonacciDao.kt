package com.mumbicodes.fibonacci.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mumbicodes.fibonacci.domain.model.FibonacciSearch
import kotlinx.coroutines.flow.Flow

@Dao
interface FibonacciDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFibonacciNumber(fibonacciSearch: FibonacciSearch)

    @Query("SELECT * from fibonacci_table")
    fun getFibonacciNumbers(): Flow<List<FibonacciSearch>>

    @Query("DELETE from fibonacci_table where fibonacciId = :fibonacciId")
    suspend fun deleteFibonacci(fibonacciId: Int)

    @Query("DELETE from fibonacci_table")
    suspend fun deleteAllFibonacciNumbers()
}
