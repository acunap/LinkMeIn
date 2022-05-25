package dev.antonioacuna.linkmein.domain.exceptions

import java.util.UUID

class NotFoundException(type: String, id: UUID) : Exception("$type with ID $id was not found.")