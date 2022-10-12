package uz.unidev.mvi_jetpack_compose.room

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import uz.unidev.mvi_jetpack_compose.data.room.LocalDatabase
import uz.unidev.mvi_jetpack_compose.data.room.dao.GroupDao
import uz.unidev.mvi_jetpack_compose.data.room.entity.GroupEntity

/**
 *  Created by Nurlibay Koshkinbaev on 11/10/2022 16:10
 */
@SmallTest
@RunWith(AndroidJUnit4::class)
class GroupDaoTest {

    private lateinit var database: LocalDatabase
    private lateinit var groupDao: GroupDao

    init {
        println("init")
    }

    @Before
    fun start() {
        println("Start")
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            LocalDatabase::class.java
        ).allowMainThreadQueries().build()

        groupDao = database.groupDao()
    }

    @After
    fun end() {
        println("End")
        database.close()
    }

    @Test
    fun `add Group`() = runBlocking {
        val groupItem = GroupEntity(1, "Android")
        groupDao.add(groupItem)
        assert(groupDao.getGroupsForTest().contains(groupItem))
    }

    @Test
    fun `delete_group`() = runBlocking {
        val groupItem = GroupEntity(1, "Android 2")
        groupDao.add(groupItem)
        groupDao.delete(groupItem)
        assert(!groupDao.getGroupsForTest().contains(groupItem))
    }

    @Test
    fun `update_group`() = runBlocking {
        val groupItem = GroupEntity(1, "Android 3")
        groupDao.add(groupItem)
        val newItem =groupItem.copy(name = "Android 4")
        groupDao.update(newItem)
        assert(!groupDao.getGroupsForTest().contains(newItem))
    }

}