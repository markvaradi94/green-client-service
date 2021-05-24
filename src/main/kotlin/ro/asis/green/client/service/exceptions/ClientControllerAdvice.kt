package ro.asis.green.client.service.exceptions

import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ClientControllerAdvice {
    @ExceptionHandler(ClientNotFoundException::class)
    @ResponseStatus(BAD_REQUEST)
    fun handleClientNotFoundException(exception: ClientNotFoundException): ApiError =
        ApiError(exception.localizedMessage)
}

data class ApiError(val message: String)

class ClientNotFoundException(message: String?) : RuntimeException(message)
