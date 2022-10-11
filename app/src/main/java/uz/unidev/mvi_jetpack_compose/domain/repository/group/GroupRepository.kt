package uz.unidev.mvi_jetpack_compose.domain.repository.group

import kotlinx.coroutines.flow.Flow
import uz.unidev.mvi_jetpack_compose.data.models.GroupFullData
import uz.unidev.mvi_jetpack_compose.data.room.entity.GroupEntity

/**
 *  Created by Nurlibay Koshkinbaev on 05/10/2022 15:45
 */

interface GroupRepository {

    suspend fun addGroup(groupEntity: GroupEntity)
    suspend fun updateGroup(groupEntity: GroupEntity)
    suspend fun deleteGroup(groupEntity: GroupEntity)
    fun getGroups(): Flow<List<GroupFullData>>

    fun getGroupsSynchronous(): List<GroupEntity>
}