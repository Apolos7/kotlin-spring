package com.example.kotlinspring.dto

import java.time.Instant
import java.util.*

data class InscricaoDTO(

    val id: UUID,
    val categosria_id: UUID,
    val usuario_id1: UUID,
    val usuario_id2: UUID,

    val createAt: Instant = Instant.now()
)
