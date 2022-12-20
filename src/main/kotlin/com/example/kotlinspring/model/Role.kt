package com.example.kotlinspring.model

import com.example.kotlinspring.enumerate.Roles
import org.springframework.security.core.GrantedAuthority
import java.util.UUID
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

data class Role(
    @Id @GeneratedValue
    val id: UUID = UUID.randomUUID(),

    val role: Roles = Roles.USER,

    @ManyToOne(targetEntity = Role::class)
    @JoinColumn(name = "usuario_id", nullable = false)
    val usuarioId: UUID = UUID.randomUUID()

): GrantedAuthority {
    override fun getAuthority(): String = role.description
}
