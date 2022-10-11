package uz.unidev.mvi_jetpack_compose.group

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.unidev.mvi_jetpack_compose.data.models.GroupFullData
import uz.unidev.mvi_jetpack_compose.data.room.entity.GroupEntity
import uz.unidev.mvi_jetpack_compose.domain.repository.group.GroupRepository

/**
 *  Created by Nurlibay Koshkinbaev on 11/10/2022 16:10
 */

class MockGroupRepository : GroupRepository {

    val list = ArrayList<GroupEntity>()

    override suspend fun addGroup(groupEntity: GroupEntity) {
        if (groupEntity.name.isNotEmpty() && groupEntity.id > 0) {
            list.add(groupEntity)
        }
    }

    override suspend fun updateGroup(groupEntity: GroupEntity) {
        for (i in 0 until list.size) {
            if (list[i].id == groupEntity.id) {
                list[i] = groupEntity
            }
        }
    }

    override suspend fun deleteGroup(groupEntity: GroupEntity) {
        list.removeIf {
            it.id == groupEntity.id
        }
    }

    override fun getGroups(): Flow<List<GroupFullData>> = flow {
        emit(list.map { GroupFullData(it.id, it.name, 0) })
    }

    override fun getGroupsSynchronous(): List<GroupEntity> {
        return list
    }
}