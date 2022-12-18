package com.example.kotlinspring.controller


import com.example.kotlinspring.dto.UsuarioDTO
import com.example.kotlinspring.repository.UsuarioRepository
import com.example.kotlinspring.service.InscricoesService
import com.example.kotlinspring.service.TorneioService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import java.lang.IllegalArgumentException
import java.util.UUID

@RestController
@RequestMapping("/torneios")
@PreAuthorize("")
class TorneioController(
    private val torneioService: TorneioService,
    private val inscricoesService: InscricoesService,
    private val usuarioRepository: UsuarioRepository,
) {

    @GetMapping("/")
    fun findAll() = torneioService.findAll()

    @GetMapping("/{torneioId}/categorias")
    fun findAllCategoriasByTorneio(@PathVariable("torneioId") id: UUID) = torneioService.findAllCategoriasByTorneio(id)

    @PostMapping("/{torneioId}/categorias/{categoriaId}")
    fun realizarInscricao(@PathVariable("categoriaId") categoriaId: UUID, @RequestHeader("Authorization") token: String, usuarioDto: UsuarioDTO) {

        when{
            usuarioRepository.existsByLogin(usuarioDto.login) -> {
                val usuario1 = usuarioRepository.findById().get()
                val usuario2 = usuarioRepository.findByLogin(usuarioDto.login)

                inscricoesService.realizarInscricao(categoriaId, usuario1.id , usuario2.id)
            }
        }

    }

}