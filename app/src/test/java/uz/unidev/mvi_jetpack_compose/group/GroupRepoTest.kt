package uz.unidev.mvi_jetpack_compose.group

import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import uz.unidev.mvi_jetpack_compose.data.room.entity.GroupEntity

/**
 *  Created by Nurlibay Koshkinbaev on 11/10/2022 16:10
 */

class GroupRepoTest {

    private lateinit var repo: MockGroupRepository

    @Before
    fun start() {
        /** Test baslaniwinan aldin isleydi */
        repo = MockGroupRepository()
    }

    @After
    fun end() {
        /** Test tamamlangannan keyin isleydi */
    }

    @Test
    fun `add_group_data_with_empty_name`() = runBlocking {
        val data = repo.getGroupsSynchronous()
        val oldSize = data.size
        repo.addGroup(GroupEntity(1, ""))
        assert(data.size == oldSize)
    }

    @Test
    fun `add_group_data_with_invalid_id`() = runBlocking {
        val data = repo.getGroupsSynchronous()
        val oldSize = data.size
        repo.addGroup(GroupEntity(0, "Hello"))
        assert(data.size == oldSize)
    }

    @Test
    fun `add_group_data_with_valid_data`() = runBlocking {
        val data = repo.getGroupsSynchronous()
        val oldSize = data.size
        repo.addGroup(GroupEntity(1, "Android"))
        assert(data.size == oldSize + 1)
    }

}