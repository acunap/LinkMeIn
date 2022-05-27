package dev.antonioacuna.linkmein.infrastructure.mock

import dev.antonioacuna.linkmein.domain.links.Link
import dev.antonioacuna.linkmein.domain.links.LinkRepository
import dev.antonioacuna.linkmein.domain.users.User
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class MockLinkRepository : LinkRepository {
    val links = emptyList<Link>()

    override fun getAll(): Collection<Link> {
        TODO("Not yet implemented")
    }

    override fun getByUser(user: User): Collection<Link> {
        TODO("Not yet implemented")
    }

    override fun getById(id: UUID): Link {
        TODO("Not yet implemented")
    }

    override fun create(link: Link): UUID {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID) {
        TODO("Not yet implemented")
    }
}