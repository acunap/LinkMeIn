package dev.antonioacuna.linkmein.domain.links

import dev.antonioacuna.linkmein.domain.users.User
import java.util.UUID

interface LinkRepository {
    fun getAll() : Collection<Link>
    fun getByUser(user: User) : Collection<Link>
    fun getById(id: UUID) : Link
    fun create(link: Link) : UUID
    fun delete(id: UUID)
}