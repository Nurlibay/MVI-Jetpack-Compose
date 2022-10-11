package uz.unidev.mvi_jetpack_compose.domain.repository.student

import kotlinx.coroutines.flow.Flow
import uz.unidev.mvi_jetpack_compose.data.room.dao.StudentDao
import uz.unidev.mvi_jetpack_compose.data.room.entity.StudentEntity
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val studentDao: StudentDao
) : StudentRepository {
    override suspend fun addStudent(studentEntity: StudentEntity) {
        studentDao.add(studentEntity)
    }

    override suspend fun updateStudent(studentEntity: StudentEntity) {
        studentDao.update(studentEntity)
    }

    override suspend fun deleteStudent(studentEntity: StudentEntity) {
        studentDao.delete(studentEntity)
    }

    override fun getStudents(groupId: Long): Flow<List<StudentEntity>> {
        return studentDao.getStudentsByGroup(groupId)
    }
}