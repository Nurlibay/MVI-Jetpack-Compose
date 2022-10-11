package uz.unidev.mvi_jetpack_compose.data.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {

    @Insert
    suspend fun add(data: T)

    @Update
    suspend fun update(data: T)

    @Delete
    suspend fun delete(data: T)
}