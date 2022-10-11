package uz.unidev.mvi_jetpack_compose.ui.group.viewmodel

import uz.unidev.mvi_jetpack_compose.data.models.GroupFullData
import uz.unidev.mvi_jetpack_compose.data.room.entity.GroupEntity
import uz.unidev.mvi_jetpack_compose.utils.AppViewModel

interface GroupViewModel : AppViewModel<Intent, UiState, SideEffect>

sealed interface UiState {
    object Empty : UiState
    object Loading : UiState
    class Success(val groups: List<GroupFullData>) : UiState
    class Error(val message: String) : UiState
}

sealed interface Intent {
    object AddDialog : Intent
    class Add(val group: GroupEntity) : Intent
    class Edit(val group: GroupEntity) : Intent
    class Delete(val group: GroupEntity) : Intent
}

enum class SideEffect {
    CLOSE, ADD_DIALOG
}