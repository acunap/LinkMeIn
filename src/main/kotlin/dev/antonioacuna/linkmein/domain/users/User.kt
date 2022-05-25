package dev.antonioacuna.linkmein.domain.users

import java.util.UUID

data class User(
    val id: UUID,
    val email: String
)