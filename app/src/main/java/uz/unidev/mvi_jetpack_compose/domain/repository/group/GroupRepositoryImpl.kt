package uz.unidev.mvi_jetpack_compose.domain.repository.group

import kotlinx.coroutines.flow.Flow
import uz.unidev.mvi_jetpack_compose.data.models.GroupFullData
import uz.unidev.mvi_jetpack_compose.data.room.dao.GroupDao
import uz.unidev.mvi_jetpack_compose.data.room.entity.GroupEntity
import javax.inject.Inject

class GroupRepositoryImpl @Inject constructor(
    private val groupDao: GroupDao
) : GroupRepository {

    override suspend fun addGroup(groupEntity: GroupEntity) {
        groupDao.add(groupEntity)
    }

    override suspend fun updateGroup(groupEntity: GroupEntity) {
        groupDao.update(groupEntity)
    }

    override suspend fun deleteGroup(groupEntity: GroupEntity) {
        groupDao.delete(groupEntity)
    }

    override fun getGroups(): Flow<List<GroupFullData>> {
        return groupDao.getGroupsWithInfo()
    }
}