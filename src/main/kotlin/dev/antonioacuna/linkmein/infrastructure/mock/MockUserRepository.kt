package dev.antonioacuna.linkmein.infrastructure.mock

import dev.antonioacuna.linkmein.domain.users.User
import dev.antonioacuna.linkmein.domain.users.UserRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class MockUserRepository : UserRepository {
    val users = emptyList<User>()

    override fun getAll(): Collection<User> {
        TODO("Not yet implemented")
    }

    override fun getById(id: UUID): User {
        TODO("Not yet implemented")
    }

    override fun create(user: User): UUID {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID) {
        TODO("Not yet implemented")
    }
}