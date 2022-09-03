package io.github.manuelernesto.taskapi.controller

import io.github.manuelernesto.taskapi.model.Task
import io.github.manuelernesto.taskapi.repository.TaskRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

/**
 * @author  Manuel Ernesto (manuelernest0)
 * @date  03/09/22 1:33 PM
 * @version 1.0
 */
@RestController
class Controller(private val taskRepository: TaskRepository) {

    @GetMapping("/")
    fun hello() = "Hello, GDG Maputo"

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody task: Task): Task = taskRepository.save(task)

    @GetMapping("/tasks")
    fun get(): List<Task> = taskRepository.findAll()

    @GetMapping("/tasks/{id}")
    fun get(@PathVariable id: Long): Task =
        taskRepository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @PutMapping("/tasks/{id}")
    fun update(@PathVariable id: Long, @RequestBody task: Task): Task {
        return if (taskRepository.existsById(id)) {
            task.id = id
            taskRepository.save(task)
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        if (taskRepository.existsById(id))
            taskRepository.deleteById(id)
        else
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}

