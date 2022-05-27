package dev.antonioacuna.linkmein.domain.users

import dev.antonioacuna.linkmein.domain.links.Link
import java.util.UUID

interface UserRepository {
    fun getAll(): Collection<User>
    fun getById(id: UUID) : User
    fun create(user: User) : UUID
    fun addLink(user: User, link: Link)
    fun delete(id: UUID)
}