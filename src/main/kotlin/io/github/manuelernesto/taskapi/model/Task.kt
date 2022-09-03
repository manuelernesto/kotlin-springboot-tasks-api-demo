package io.github.manuelernesto.taskapi.model

import javax.persistence.*

@Entity
@Table(name = "Task")
class Task(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
    val title: String,
    val status: Status
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Task

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}