package com.example.kotlinspring.dto

import java.time.Instant
import java.util.*

data class CategoriaDTo(
    val id: UUID,
    val torneioId: UUID,
    val nome: String?,
)
