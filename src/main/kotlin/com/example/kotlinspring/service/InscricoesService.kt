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

    fun realizarInscricao(torneioId: UUID, inscricaoDTO: InscricaoDTO): Any {

        val inscricao = Inscricao().dtoToInsncricao(inscricaoDTO)

        val torneio = torneioRepository.findById(torneioId).get()
        val categorias = torneio.categorias
        val categoria = categorias.stream().filter { it.id == inscricao.categoriaId }.findFirst()

        return when {
            !usuarioRepository.existsById(inscricao.usuarioId1) -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado ID: ${inscricao.usuarioId1}!")
            !usuarioRepository.existsById(inscricao.usuarioId2)-> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado ID: ${inscricao.usuarioId1}")
            !torneioRepository.existsById(torneioId) -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Torneio não encontrado ID: $torneioId")
            torneioRepository.existsById(torneioId) -> {
               return if (categoria.isPresent) {
                    inscricaoRepository.save(inscricao)
                    ResponseEntity.status(HttpStatus.CREATED).body(inscricao)
                }else{
                   ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada")
                }
            }
            else -> throw IllegalArgumentException("Não foi possível realizar a Inscrição")
        }
    }

}