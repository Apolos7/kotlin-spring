package com.example.kotlinspring.model

import java.io.Serializable
import java.time.Instant
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
@Entity
data class Inscricao(
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),
    val usuario_id: UUID = UUID.randomUUID(),
    val usuario_id_2: UUID = UUID.randomUUID(),
    val createAt: Instant = Instant.now(),
): Serializable
