package com.example.kotlinspring.model


import java.io.Serializable
import java.time.Instant
import java.util.ArrayList
import java.util.UUID
import javax.persistence.*

@Entity(name = "tb_usuarios")
data class Usuario(

        @Id
        @GeneratedValue
        val id: UUID = UUID.randomUUID(),

        @Column(nullable = false)
        val nome: String = "",

        @Column(unique = true, nullable = false)
        val login: String = "",

        @Column(nullable = false)
        var senha: String = "",

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "id")
        val inscricoes: List<Inscricao> = ArrayList(),

        val createAt: Instant = Instant.now(),
        var updateAt: Instant = Instant.now()
): Serializable