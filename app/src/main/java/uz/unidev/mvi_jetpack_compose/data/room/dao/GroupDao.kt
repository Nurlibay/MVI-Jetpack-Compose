package uz.unidev.mvi_jetpack_compose.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.unidev.mvi_jetpack_compose.data.models.GroupFullData
import uz.unidev.mvi_jetpack_compose.data.room.entity.GroupEntity

@Dao
interface GroupDao : BaseDao<GroupEntity> {

    @Query("SELECT * FROM GroupEntity")
    fun getGroups(): Flow<List<GroupEntity>>

    @Query("SELECT g.id, g.name, COUNT(s.id) as count FROM  GroupEntity g LEFT JOIN StudentEntity s ON g.id=s.groupId GROUP BY g.id")
    fun getGroupsWithInfo(): Flow<List<GroupFullData>>

}