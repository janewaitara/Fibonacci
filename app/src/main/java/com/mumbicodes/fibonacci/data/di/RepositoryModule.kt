package com.mumbicodes.fibonacci.data.di

import com.mumbicodes.fibonacci.data.db.FibonacciDatabase
import com.mumbicodes.fibonacci.data.repository.FibonacciRepositoryImpl
import com.mumbicodes.fibonacci.domain.repository.FibonacciRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProjectsRepository(db: FibonacciDatabase): FibonacciRepository {
        return FibonacciRepositoryImpl(db.fibonacciNumbersDao())
    }
}
