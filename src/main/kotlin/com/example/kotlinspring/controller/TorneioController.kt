package com.example.kotlinspring.controller

import com.example.kotlinspring.service.TorneioService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid

@RestController
@RequestMapping("/torneios")
class TorneioController(
    private val torneioService: TorneioService
) {

    @GetMapping("")
    fun findAll() = torneioService.findAll()

    @GetMapping("/{id}/categorias")
    fun findAllCategorais(@Valid @RequestParam id: UUID) = torneioService.findAllCategorias(id)

}