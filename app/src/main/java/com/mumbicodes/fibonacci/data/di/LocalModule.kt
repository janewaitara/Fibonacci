package com.mumbicodes.fibonacci.data.di

import android.content.Context
import androidx.room.Room
import com.mumbicodes.fibonacci.data.db.FibonacciDatabase
import com.mumbicodes.fibonacci.data.db.ListConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideProjectsDatabase(@ApplicationContext context: Context): FibonacciDatabase {
        return Room.databaseBuilder(
            context,
            FibonacciDatabase::class.java,
            DATABASE_NAME
        )
            .addTypeConverter(ListConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    private const val DATABASE_NAME = "fibonacci_db"
}
