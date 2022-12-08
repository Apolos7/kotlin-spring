package com.example.kotlinspring.controller

import com.example.kotlinspring.dto.UsuarioDTO
import com.example.kotlinspring.service.UsuarioService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid


@RestController
@RequestMapping("v1/api/usuarios")
class UsuarioController(
    private val usuarioService: UsuarioService
){

    @PostMapping()
    fun create(@Valid @RequestBody usuario: UsuarioDTO) = usuarioService.create(usuario)

    @GetMapping("/{id}")
    fun findById(@RequestParam("id") id: UUID) = usuarioService.findById(id)

    @PutMapping("/{id}")
    fun update(@Valid @RequestParam("id") id: UUID, @RequestBody usuario: UsuarioDTO) = usuarioService.update(id,usuario)

    @DeleteMapping("/{id}")
    fun delete(@RequestParam("id") id: UUID) = usuarioService.delete(id)

}