package com.example.kotlinspring.service


import com.example.kotlinspring.dto.InscricaoDTO
import com.example.kotlinspring.mapper.dtoToInsncricao
import com.example.kotlinspring.model.Inscricao
import com.example.kotlinspring.repository.InscricaoRepository
import com.example.kotlinspring.repository.TorneioRepository
import com.example.kotlinspring.repository.UsuarioRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.*

@Service
class InscricoesService (
    private val inscricaoRepository: InscricaoRepository,
    private val torneioRepository: TorneioRepository,
    private val usuarioRepository: UsuarioRepository
    ){

    fun realizarInscricao(categoriaId: UUID, usuarioId1: UUID, usuarioId2: UUID): ResponseEntity<Any> {
        val inscricaoDTO: InscricaoDTO = InscricaoDTO(categoriaId = categoriaId, usuarioId1 = usuarioId1, usuarioId2 = usuarioId2)
        val inscricao = Inscricao().dtoToInsncricao(inscricaoDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricao)
    }

}