package com.example.kotlinspring.dto

import java.time.Instant
import java.util.*

data class InscricaoDTO(
    val id: UUID,
    val usuario_id: UUID,
    val usuario_id_2: UUID,
    val createAt: Instant = Instant.now()

)
