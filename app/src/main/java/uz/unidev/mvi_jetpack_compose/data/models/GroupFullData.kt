package uz.unidev.mvi_jetpack_compose.data.models

import uz.unidev.mvi_jetpack_compose.data.room.entity.GroupEntity

data class GroupFullData(
    val id: Long,
    val name: String,
    val count: Int
) {
    fun toGroupEntity() = GroupEntity(id, name)
}
