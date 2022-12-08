package com.example.kotlinspring.repository

import com.example.kotlinspring.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UsuarioRepository : JpaRepository<Usuario, UUID>{
    fun existsByUsername(username: String): Boolean
}