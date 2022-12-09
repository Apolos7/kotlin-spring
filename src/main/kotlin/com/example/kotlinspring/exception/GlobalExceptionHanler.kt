package com.example.kotlinspring.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.HashMap


@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun handleException(ex: MethodArgumentNotValidException): ResponseEntity<Any> {
        val errors: HashMap<String,String> = HashMap<String,String>()
        ex.bindingResult.fieldErrors.forEach {
            errors[it.field] = it.defaultMessage.toString()
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors)
    }
}
