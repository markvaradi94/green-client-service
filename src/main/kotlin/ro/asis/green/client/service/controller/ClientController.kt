package ro.asis.green.client.service.controller

import org.springframework.web.bind.annotation.*
import ro.asis.green.client.service.exceptions.ClientNotFoundException
import ro.asis.green.client.service.model.api.dto.ClientDto
import ro.asis.green.client.service.model.filters.ClientFilters
import ro.asis.green.client.service.model.mappers.ClientMapper
import ro.asis.green.client.service.service.ClientService

@RestController
@RequestMapping("clients")
class ClientController(
    private val clientService: ClientService,
    private val mapper: ClientMapper
) {
    @GetMapping
    fun getAllClients(filters: ClientFilters) = mapper.toApi(
        clientService.findAll(filters)
    )

    @GetMapping("{clientId}")
    fun getById(@PathVariable clientId: String) = mapper.toApi(
        clientService.findById(clientId)
            .orElseThrow { ClientNotFoundException("Could not find client") }
    )

    @PostMapping
    fun addClient(@RequestBody client: ClientDto) = mapper.toApi(
        clientService.addClient(mapper.toEntity(client))
    )

    @PutMapping("{clientId}")
    fun updateClient(
        @PathVariable clientId: String,
        @RequestBody client: ClientDto
    ) = mapper.toApi(
        clientService.updateClient(clientId, mapper.toEntity(client))
    )

    @DeleteMapping("{clientId}")
    fun deleteClient(@PathVariable clientId: String) = mapper.toApi(
        clientService.deleteById(clientId)
    )
}
