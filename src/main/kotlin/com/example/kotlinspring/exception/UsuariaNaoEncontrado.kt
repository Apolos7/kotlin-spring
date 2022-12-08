package com.example.kotlinspring.exception

import java.lang.Exception

class UsuarioNaoEncontrado(override val message: String?): Exception(message)