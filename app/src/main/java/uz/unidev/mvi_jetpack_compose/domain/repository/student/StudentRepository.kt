package uz.unidev.mvi_jetpack_compose.domain.repository.student

import kotlinx.coroutines.flow.Flow
import uz.unidev.mvi_jetpack_compose.data.room.entity.StudentEntity

/**
 *  Created by Nurlibay Koshkinbaev on 05/10/2022 15:48
 */

interface StudentRepository {

    suspend fun addStudent(studentEntity: StudentEntity)

    suspend fun updateStudent(studentEntity: StudentEntity)

    suspend fun deleteStudent(studentEntity: StudentEntity)

    fun getStudents(groupId: Long): Flow<List<StudentEntity>>

}