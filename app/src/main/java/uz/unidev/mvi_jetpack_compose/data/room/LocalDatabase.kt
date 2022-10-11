package uz.unidev.mvi_jetpack_compose.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.unidev.mvi_jetpack_compose.data.room.dao.GroupDao
import uz.unidev.mvi_jetpack_compose.data.room.dao.StudentDao
import uz.unidev.mvi_jetpack_compose.data.room.entity.GroupEntity
import uz.unidev.mvi_jetpack_compose.data.room.entity.StudentEntity

/**
 *  Created by Nurlibay Koshkinbaev on 05/10/2022 15:25
 */

@Database(
    entities = [GroupEntity::class, StudentEntity::class],
    version = 1,
    exportSchema = false
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun groupDao(): GroupDao
    abstract fun studentDao(): StudentDao
}