package dev.antonioacuna.linkmein.domain.links

import dev.antonioacuna.linkmein.domain.users.User
import java.util.UUID

data class Link(
    val id: UUID,
    val description: String,
    val url: String,
    val user: User
)
