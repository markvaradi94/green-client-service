package ro.asis.green.client.service.exceptions

import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ClientControllerAdvice {
    @ExceptionHandler(ClientNotFoundException::class)
    @ResponseStatus(NOT_FOUND)
    fun handleClientNotFoundException(exception: ClientNotFoundException): ApiError =
        ApiError(exception.localizedMessage)

    @ExceptionHandler(NoSuchElementException::class)
    @ResponseStatus(NOT_FOUND)
    fun handleNoSuchElementException(exception: NoSuchElementException): ApiError =
        ApiError(exception.localizedMessage)
}

data class ApiError(val message: String)

class ClientNotFoundException(message: String?) : RuntimeException(message)
