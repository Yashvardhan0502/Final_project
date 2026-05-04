package com.example.accessiread.di

import android.content.Context
import androidx.room.Room
import com.example.accessiread.data.datastore.SettingsStore
import com.example.accessiread.data.db.HistoryDao
import com.example.accessiread.data.db.HistoryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides @Singleton fun provideStore(@ApplicationContext context: Context) = SettingsStore(context)
    @Provides @Singleton fun provideDb(@ApplicationContext context: Context) = Room.databaseBuilder(context, HistoryDatabase::class.java, "history.db").build()
    @Provides fun provideDao(db: HistoryDatabase): HistoryDao = db.dao()
}
