package com.example.kotlinspring.exception

import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.HashMap


@ControllerAdvice
class GlobalExceptionHanler {

    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun handleException(ex: MethodArgumentNotValidException): Map<String,String>{
        val errors: HashMap<String,String> = HashMap()

        ex.bindingResult.allErrors.forEach {
            val fieldName = it.objectName
            val errorMessage: String = it.defaultMessage as String
            errors[fieldName] = errorMessage
        }

        return errors
    }
}
