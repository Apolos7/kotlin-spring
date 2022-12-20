package com.example.kotlinspring.enumerate

import org.springframework.security.core.GrantedAuthority

enum class Roles (val description: String){
    USER("usuario"),
    ADMIN("admin")
}