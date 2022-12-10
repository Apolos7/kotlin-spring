package com.example.kotlinspring.model


import com.example.kotlinspring.enumarators.Role
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
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

        @OneToMany
        val roles: List<Roles> = ArrayList(),

        val createAt: Instant = Instant.now(),
        var updateAt: Instant = Instant.now()

): Serializable, UserDetails {
        override fun getAuthorities(): MutableList<SimpleGrantedAuthority>? =
                roles.stream().map{it -> SimpleGrantedAuthority(it.role.name)}.toList()
        override fun getPassword(): String = senha
        override fun getUsername(): String = login
        override fun isAccountNonExpired(): Boolean  = true
        override fun isAccountNonLocked(): Boolean = true
        override fun isCredentialsNonExpired(): Boolean = true
        override fun isEnabled(): Boolean = true
}