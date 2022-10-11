package uz.unidev.mvi_jetpack_compose.ui.group.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.unidev.mvi_jetpack_compose.data.room.entity.GroupEntity
import uz.unidev.mvi_jetpack_compose.domain.repository.group.GroupRepository
import javax.inject.Inject

@HiltViewModel
class GroupViewModelImpl @Inject constructor(
    private val repository: GroupRepository
) : GroupViewModel, ViewModel() {

    init {
        repository.getGroups().onEach {
            delay(500)
            intent {
                reduce {
                    if (it.isEmpty()) {
                        UiState.Empty
                    } else {
                        UiState.Success(it)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    override fun onEventDispatcher(intent: Intent) {
        viewModelScope.launch {
            when(intent){
                Intent.AddDialog -> {
                    repository.addGroup(GroupEntity(0, "Android"))
                    intent {
                        postSideEffect(SideEffect.ADD_DIALOG)
                    }
                }
                is Intent.Add -> {
                    repository.addGroup(intent.group)
                }
                is Intent.Edit -> {
                    repository.updateGroup(intent.group)
                }
                is Intent.Delete -> {
                    repository.deleteGroup(intent.group)
                }
            }
        }
    }

    override val container: Container<UiState, SideEffect> = container(UiState.Loading)

}