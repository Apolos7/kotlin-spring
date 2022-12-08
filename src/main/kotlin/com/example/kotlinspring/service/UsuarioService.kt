package com.example.kotlinspring.service

import com.example.kotlinspring.dto.UsuarioDTO
import com.example.kotlinspring.exception.GlobalExceptionHanler
import com.example.kotlinspring.exception.UsuarioNaoEncontrado
import com.example.kotlinspring.mapper.dtoToUsuario
import com.example.kotlinspring.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.net.URI
import java.util.UUID

@Service
class UsuarioService{

    lateinit var usuarioRepository: UsuarioRepository

    fun create(usuarioDTO: UsuarioDTO): ResponseEntity<Any>{
        val usuario = usuarioDTO.dtoToUsuario(usuarioDTO)
        return if (usuarioRepository.existsById(usuario.id)){
           ResponseEntity.badRequest().body(GlobalExceptionHanler::handleException)
        }else{
            ResponseEntity.created(URI.create("/${usuario.id}")).build()
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