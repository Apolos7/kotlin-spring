package com.example.kotlinspring.model


import java.io.Serializable
import java.time.Instant
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "tb_usuarios")
data class Usuario(
        @Id
        @GeneratedValue
        val id: UUID = UUID.randomUUID(),

        @Column(unique = true, nullable = false)
        val username: String = "",

        @Column(nullable = false)
        var password: String = "",

        val createAt: Instant = Instant.now(),
        var updateAt: Instant = Instant.now()
): Serializable