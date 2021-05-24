package ro.asis.green.client.service.controller

import org.springframework.web.bind.annotation.*
import ro.asis.green.client.service.exceptions.ClientNotFoundException
import ro.asis.green.client.service.model.api.dto.ClientDto
import ro.asis.green.client.service.model.api.dto.GreenBagDto
import ro.asis.green.client.service.model.entity.Cart
import ro.asis.green.client.service.model.filters.ClientFilters
import ro.asis.green.client.service.model.mappers.ClientMapper
import ro.asis.green.client.service.model.mappers.GreenBagMapper
import ro.asis.green.client.service.service.ClientService

@RestController
@RequestMapping("clients")
class ClientController(
    private val clientService: ClientService,
    private val clientMapper: ClientMapper,
    private val greenBagMapper: GreenBagMapper
) {
    @GetMapping
    fun getAllClients(filters: ClientFilters) = clientMapper.toApi(
        clientService.findAll(filters)
    )

    @GetMapping("{clientId}")
    fun getById(@PathVariable clientId: String) = clientMapper.toApi(
        clientService.findById(clientId)
            .orElseThrow { ClientNotFoundException("Could not find client") }
    )

    @GetMapping("{clientId}/cart")
    fun getClientCart(@PathVariable clientId: String) = clientService.getClientCart(clientId)

    @PostMapping("{clientId}/cart")
    fun addBagToCart(
        @PathVariable clientId: String,
        @RequestBody bag: GreenBagDto
    ) = clientService.addBagToCart(clientId, greenBagMapper.toEntity(bag))

    //TODO add functionality for deleting a bag from the client cart

    @PutMapping("{clientId}/cart")
    fun updateClientCart(
        @PathVariable clientId: String,
        @RequestBody cart: Cart
    ) = clientService.updateCartForClient(clientId, cart)

    @PostMapping
    fun addClient(@RequestBody client: ClientDto) = clientMapper.toApi(
        clientService.addClient(clientMapper.toEntity(client))
    )

    @PutMapping("{clientId}")
    fun updateClient(
        @PathVariable clientId: String,
        @RequestBody client: ClientDto
    ) = clientMapper.toApi(
        clientService.updateClient(clientId, clientMapper.toEntity(client))
    )

    @DeleteMapping("{clientId}")
    fun deleteClient(@PathVariable clientId: String) = clientMapper.toApi(
        clientService.deleteById(clientId)
    )
}
