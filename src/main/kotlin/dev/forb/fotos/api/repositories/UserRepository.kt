package dev.forb.fotos.api.repositories

import dev.forb.fotos.api.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long> {
    fun findByEmail(email: String): User?
    fun findByUsername(username: String): User?
}
