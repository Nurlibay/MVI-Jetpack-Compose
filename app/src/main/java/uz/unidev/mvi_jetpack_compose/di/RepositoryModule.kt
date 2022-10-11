package uz.unidev.mvi_jetpack_compose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.unidev.mvi_jetpack_compose.domain.repository.group.GroupRepository
import uz.unidev.mvi_jetpack_compose.domain.repository.group.GroupRepositoryImpl
import uz.unidev.mvi_jetpack_compose.domain.repository.student.StudentRepository
import uz.unidev.mvi_jetpack_compose.domain.repository.student.StudentRepositoryImpl

/**
 *  Created by Nurlibay Koshkinbaev on 05/10/2022 15:54
 */

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindGroupRepository(impl: GroupRepositoryImpl): GroupRepository

    @Binds
    fun bindStudentRepository(impl: StudentRepositoryImpl): StudentRepository
}