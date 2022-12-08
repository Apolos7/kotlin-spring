package com.example.kotlinspring.model

import java.util.UUID

data class Categoria(
    val id: UUID,
    val torneioId: UUID,
    val nome: String?,
)
