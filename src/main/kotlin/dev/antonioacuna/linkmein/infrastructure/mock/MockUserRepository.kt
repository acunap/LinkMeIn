package dev.antonioacuna.linkmein.infrastructure.mock

import dev.antonioacuna.linkmein.domain.exceptions.NotFoundException
import dev.antonioacuna.linkmein.domain.users.User
import dev.antonioacuna.linkmein.domain.users.UserRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class MockUserRepository(
    private val users : MutableCollection<User> = mutableListOf()
) : UserRepository {

    override fun getAll(): Collection<User> = users

    override fun getById(id: UUID): User = users.find { user -> user.id == id } ?: throw NotFoundException("User", id)

    override fun create(user: User): UUID {
        users.add(user)
        return user.id
    }

    override fun delete(id: UUID) = if (users.removeIf { user -> user.id == id }) Unit else throw NotFoundException("User", id)
}
