package dev.antonioacuna.linkmein.unit.infrastrusture.mock

import dev.antonioacuna.linkmein.domain.exceptions.NotFoundException
import dev.antonioacuna.linkmein.domain.links.Link
import dev.antonioacuna.linkmein.domain.users.User
import dev.antonioacuna.linkmein.infrastructure.mock.MockLinkRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.util.UUID

class MockLinkRepositoryTest {
    private val user = User(UUID.randomUUID(), "first@email.com", mutableListOf())

    private val mockLinks = mutableListOf(
        Link(UUID.randomUUID(), "First link", "https://url.com", user),
        Link(UUID.randomUUID(), "Second link", "https://url.com", user),
        Link(UUID.randomUUID(), "Third link", "https://url.com", user)
    )

    private val mockLinkRepository = MockLinkRepository(mockLinks)

    @Test
    fun `get all should return all links`() {
        val links = mockLinkRepository.getAll()
        Assertions.assertThat(links).isNotEmpty
        Assertions.assertThat(links.size).isEqualTo(3)
    }

    @Test
    fun `get by user should return the posts owned for this user`() {
        val linksByUser = mockLinkRepository.getByUser(user)
        Assertions.assertThat(linksByUser).isEqualTo(mockLinks)
    }

    @Test
    fun `get link by id should return the right one`() {
        val searchedLink = mockLinks[0]
        val selectedLink = mockLinkRepository.getById(searchedLink.id)

        Assertions.assertThat(selectedLink).isEqualTo(searchedLink)
    }

    @Test
    fun `get user that doesn't exist by id should throw NotFoundException`() {
        assertThrows<NotFoundException> {
            mockLinkRepository.getById(UUID.randomUUID())
        }
    }

    @Test
    fun `create user should return new user id`() {
        val newLink = Link(UUID.randomUUID(), "Fourth link", "https://url.com", user)
        val linkCreatedId = mockLinkRepository.create(newLink)

        Assertions.assertThat(linkCreatedId).isEqualTo(newLink.id)
    }

    @Test
    fun `delete user by id should return Unit`() {
        val searchedLink = mockLinks[0]
        assertDoesNotThrow {
            mockLinkRepository.delete(searchedLink.id)
        }
    }

    @Test
    fun `delete user that doesn't exist by id should throw NotFoundException`() {
        assertThrows<NotFoundException> {
            mockLinkRepository.delete(UUID.randomUUID())
        }
    }
}