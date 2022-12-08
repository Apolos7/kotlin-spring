package com.example.kotlinspring.model

import java.time.Instant
import java.util.*

data class Inscricao(
    val id: UUID,
    val usuario_id: UUID,
    val usuario_id_2: UUID,
    val createAt: Instant = Instant.now(),
)
