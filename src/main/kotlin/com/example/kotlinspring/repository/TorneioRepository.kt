package com.example.kotlinspring.repository

import com.example.kotlinspring.model.Torneio
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TorneioRepository : JpaRepository<Torneio, UUID>{
}