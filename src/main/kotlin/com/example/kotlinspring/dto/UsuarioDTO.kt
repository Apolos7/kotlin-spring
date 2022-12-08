package com.example.kotlinspring.dto



import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.Instant
import java.util.*


data class UsuarioDTO(
    val id: UUID = UUID.randomUUID(),

    @NotBlank(message = "Usuário não pode ser nulo")
    val username: String?,

    @NotBlank(message = "Senha não pode ser nula")
    @Size(min = 6, message = "Senha não pode ser inferior a 6 digitos")
    var password: String?,

    val createAt: Instant = Instant.now(),
    var updateAt: Instant = Instant.now()
)
