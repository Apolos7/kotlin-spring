package com.example.kotlinspring.mapper

import com.example.kotlinspring.dto.UsuarioDTO
import com.example.kotlinspring.model.Usuario

fun Usuario.usuarioToDTO(usuario: Usuario): UsuarioDTO{
    return UsuarioDTO(usuario.id,usuario.username,usuario.password)
}

fun UsuarioDTO.dtoToUsuario(usuarioDTO: UsuarioDTO): Usuario{
    return Usuario(usuarioDTO.id,usuarioDTO.username,usuarioDTO.password)
}