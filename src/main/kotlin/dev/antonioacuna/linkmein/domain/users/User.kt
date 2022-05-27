package dev.antonioacuna.linkmein.domain.users

import dev.antonioacuna.linkmein.domain.links.Link
import java.util.UUID

data class User(
    val id: UUID,
    val email: String,
    val links: MutableCollection<Link>
)