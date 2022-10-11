package uz.unidev.mvi_jetpack_compose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.unidev.mvi_jetpack_compose.data.room.LocalDatabase
import uz.unidev.mvi_jetpack_compose.data.room.dao.GroupDao
import uz.unidev.mvi_jetpack_compose.data.room.dao.StudentDao
import javax.inject.Singleton

/**
 *  Created by Nurlibay Koshkinbaev on 05/10/2022 15:39
 */

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @[Provides Singleton]
    fun provideDatabase(@ApplicationContext context: Context): LocalDatabase {
        return Room.databaseBuilder(
            context,
            LocalDatabase::class.java,
            "local_database.db"
        ).build()
    }

    @[Provides Singleton]
    fun provideGroupDao(localDatabase: LocalDatabase): GroupDao {
        return localDatabase.groupDao()
    }

    @[Provides Singleton]
    fun provideStudentDao(localDatabase: LocalDatabase): StudentDao {
        return localDatabase.studentDao()
    }
}