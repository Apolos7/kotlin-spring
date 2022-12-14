package com.example.kotlinspring.repository

import com.example.kotlinspring.model.Inscricao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface InscricaoRepository : JpaRepository<Inscricao, UUID>{
    fun findIncricoesByUsuarioIdOrUsuarioId2(id: UUID): List<Inscricao>
}