package dev.antonioacuna.linkmein.infrastructure.mock

import dev.antonioacuna.linkmein.domain.exceptions.NotFoundException
import dev.antonioacuna.linkmein.domain.links.Link
import dev.antonioacuna.linkmein.domain.links.LinkRepository
import dev.antonioacuna.linkmein.domain.users.User
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class MockLinkRepository(
    private val links: MutableCollection<Link>
) : LinkRepository {

    override fun getAll(): Collection<Link> = links

    override fun getByUser(user: User): Collection<Link> = links.filter { link -> link.user == user }

    override fun getById(id: UUID): Link = links.find { link -> link.id == id } ?: throw NotFoundException("Link", id)

    override fun create(link: Link): UUID {
        links.add(link)
        return link.id
    }

    override fun delete(id: UUID) = if (links.removeIf { link -> link.id == id }) Unit else throw NotFoundException("Link", id)
}