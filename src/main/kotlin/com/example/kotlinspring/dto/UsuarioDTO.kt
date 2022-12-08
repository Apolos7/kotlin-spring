package com.example.kotlinspring.dto

import java.time.Instant
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size


data class UsuarioDTO(
    val id: UUID = UUID.randomUUID(),

    @field: NotBlank(message = "Usuário é obrigatório")
    val username: String,

    @field: NotBlank(message = "Usuário é obrigatório")
    @field: Size(min = 6, message = "Senha não pode ser inferior a 6 digitos")
    var password: String,

    val createAt: Instant = Instant.now(),
    var updateAt: Instant = Instant.now()
)
