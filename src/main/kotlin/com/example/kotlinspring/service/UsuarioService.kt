package com.example.kotlinspring.service

import com.example.kotlinspring.dto.UsuarioDTO
import com.example.kotlinspring.exception.GlobalExceptionHandler
import com.example.kotlinspring.mapper.dtoToUsuario
import com.example.kotlinspring.repository.UsuarioRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.net.URI
import java.util.UUID

@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository
){
    fun create(usuarioDTO: UsuarioDTO): ResponseEntity<Any>{
        return if (usuarioRepository.existsByLogin(usuarioDTO.login)){
           ResponseEntity.badRequest().build()
        }else{
            usuarioRepository.save(usuarioDTO.dtoToUsuario(usuarioDTO))
            ResponseEntity.created(URI.create("/${usuarioDTO.id}")).build()
        }
    }

    fun findById(id: UUID): ResponseEntity<Any> {
        return if (usuarioRepository.existsById(id)){
            ResponseEntity.notFound().build()
        }else{
            ResponseEntity.ok(usuarioRepository.findById(id).get())
        }
    }

    fun update(id: UUID,usuarioDTO: UsuarioDTO): ResponseEntity<Any>{
        val usuario = usuarioDTO.dtoToUsuario(usuarioDTO)
        return if (usuarioRepository.existsById(id)) {
            usuarioRepository.save(usuario)
            ResponseEntity.ok().build()
        }else{
            ResponseEntity.notFound().build()
        }
    }

    fun delete(id: UUID): ResponseEntity<Any>{
        return if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id)
            ResponseEntity.noContent().build()
        }else{
            ResponseEntity.notFound().build()
        }
    }

}