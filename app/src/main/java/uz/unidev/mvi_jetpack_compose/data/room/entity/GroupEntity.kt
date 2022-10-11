package uz.unidev.mvi_jetpack_compose.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *  Created by Nurlibay Koshkinbaev on 05/10/2022 15:25
 */

@Entity
data class GroupEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String
)