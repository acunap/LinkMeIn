package dev.antonioacuna.linkmein.unit.infrastrusture.mock

import dev.antonioacuna.linkmein.domain.exceptions.NotFoundException
import dev.antonioacuna.linkmein.domain.users.User
import dev.antonioacuna.linkmein.infrastructure.mock.MockUserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.util.*

class MockUserRepositoryTest {
    private val mockUsers = mutableListOf(
        User(UUID.randomUUID(), "first@email.com", mutableListOf()),
        User(UUID.randomUUID(), "second@email.com", mutableListOf()),
        User(UUID.randomUUID(), "third@email.com", mutableListOf()),
    )

    private val mockUserRepository = MockUserRepository(mockUsers)

    @Test
    fun `get all should return all users`() {
        val users = mockUserRepository.getAll()
        assertThat(users).isNotEmpty
        assertThat(users.size).isEqualTo(3)
    }

    @Test
    fun `get user by id should return the right one`() {
        val searchedUser = mockUsers[0]
        val selectedUser = mockUserRepository.getById(searchedUser.id)

        assertThat(selectedUser).isEqualTo(searchedUser)
    }

    @Test
    fun `get user that doesn't exist by id should throw NotFoundException`() {
        assertThrows<NotFoundException> {
            mockUserRepository.getById(UUID.randomUUID())
        }
    }

    @Test
    fun `create user should return new user id`() {
        val newUser = User(UUID.randomUUID(), "fourth@email.com",  mutableListOf())
        val userCreatedId = mockUserRepository.create(newUser)

        assertThat(userCreatedId).isEqualTo(newUser.id)
    }

    @Test
    fun `delete user by id should return Unit`() {
        val searchedUser = mockUsers[0]
        assertDoesNotThrow {
            mockUserRepository.delete(searchedUser.id)
        }
    }

    @Test
    fun `delete user that doesn't exist by id should throw NotFoundException`() {
        assertThrows<NotFoundException> {
            mockUserRepository.delete(UUID.randomUUID())
        }
    }
}