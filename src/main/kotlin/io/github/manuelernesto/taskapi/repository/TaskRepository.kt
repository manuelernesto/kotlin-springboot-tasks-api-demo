package io.github.manuelernesto.taskapi.repository

import io.github.manuelernesto.taskapi.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : JpaRepository<Task, Long>