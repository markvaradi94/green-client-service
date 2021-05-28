package ro.asis.green.client.service.controller

import org.springframework.web.bind.annotation.*
import ro.asis.green.client.service.model.api.dto.ClientAccountDto
import ro.asis.green.client.service.model.api.dto.ClientDto
import ro.asis.green.client.service.model.entity.Address
import ro.asis.green.client.service.model.entity.Cart
import ro.asis.green.client.service.model.entity.GreenBag
import ro.asis.green.client.service.model.filters.ClientFilters
import ro.asis.green.client.service.service.ClientService

@RestController
@RequestMapping("clients")
class ClientController(
    private val clientService: ClientService,
) {
    @GetMapping
    fun getAllClients(filters: ClientFilters): List<ClientDto> = clientService.findAll(filters)

    @GetMapping("{clientId}")
    fun getClientById(@PathVariable clientId: String): ClientDto = clientService.findClient(clientId)

    @GetMapping("{clientId}/account")
    fun getClientWithAccount(@PathVariable clientId: String): ClientAccountDto =
        clientService.getClientWithAccount(clientId)

    @PostMapping
    fun addClient(@RequestBody client: ClientDto): ClientDto = clientService.addClient(client)

    @PatchMapping("{clientId}")
    fun patchClient(
        @PathVariable clientId: String,
        @RequestBody client: ClientDto
    ): ClientDto = clientService.patchClient(clientId, client)

    @DeleteMapping("{clientId}")
    fun deleteClient(@PathVariable clientId: String): ClientDto = clientService.deleteClient(clientId)

    @GetMapping("{clientId}/cart")
    fun getClientCart(@PathVariable clientId: String): Cart = clientService.getClientCart(clientId)

    @DeleteMapping("{clientId}/cart")
    fun deleteClientCart(@PathVariable clientId: String): ClientDto = clientService.deleteClientCart(clientId)

    @PostMapping("{clientId}/cart")
    fun addBagToCart(
        @PathVariable clientId: String,
        @RequestBody bag: GreenBag
    ): ClientDto = clientService.addBagToCart(clientId, bag)

    @GetMapping("{clientId}/cart/{bagId}")
    fun getBag(
        @PathVariable clientId: String,
        @PathVariable bagId: String
    ): GreenBag = clientService.getBagForClient(clientId, bagId)

    @DeleteMapping("{clientId}/cart/{bagId}")
    fun deleteBagFromCart(
        @PathVariable clientId: String,
        @PathVariable bagId: String
    ): ClientDto = clientService.deleteBagFromCart(clientId, bagId)

    @GetMapping("{clientId}/address")
    fun getClientAddress(@PathVariable clientId: String): Address = clientService.getClientAddress(clientId)

    @PatchMapping("{clientId}/address")
    fun patchClientAddress(
        @PathVariable clientId: String,
        @RequestBody address: Address
    ): ClientDto =
        clientService.patchClientAddress(clientId, address)

    @DeleteMapping("{clientId}/address")
    fun deleteClientAddress(@PathVariable clientId: String): ClientDto = clientService.deleteClientAddress(clientId)
}
