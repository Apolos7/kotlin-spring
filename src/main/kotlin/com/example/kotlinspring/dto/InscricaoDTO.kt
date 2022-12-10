package com.example.kotlinspring.dto

import java.time.Instant
import java.util.*
import javax.validation.constraints.NotBlank

data class InscricaoDTO(

    val id: UUID,

    @field: NotBlank(message = "A categoria não pode ser nula")
    val categoria_id: UUID,

    @field: NotBlank(message = "O primeiro usuário não pode ser nulo")
    val usuario_id1: UUID,

    @field: NotBlank(message = "O segundo usuário não pode ser nulo")
    val usuario_id2: UUID,

    val createAt: Instant = Instant.now()
)
