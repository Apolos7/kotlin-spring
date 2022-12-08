package com.example.kotlinspring.model

import java.io.Serializable
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Torneio(
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),
    val nome: String? = ""
): Serializable