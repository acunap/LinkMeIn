package dev.antonioacuna.linkmein.domain.users

import java.util.UUID

interface UserRepository {
    fun getAll(): Collection<User>
    fun getById(id: UUID) : User
    fun create(user: User) : UUID
    fun delete(id: UUID)
}