package ro.asis.green.client.service.service

import com.mongodb.annotations.ThreadSafe
import mu.KotlinLogging
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ro.asis.green.client.service.exceptions.ClientNotFoundException
import ro.asis.green.client.service.model.api.dto.AccountDto
import ro.asis.green.client.service.model.api.dto.ClientDto
import ro.asis.green.client.service.model.entity.*
import ro.asis.green.client.service.model.filters.ClientFilters
import ro.asis.green.client.service.model.mappers.ClientMapper
import ro.asis.green.client.service.repository.ClientAccountRepository
import ro.asis.green.client.service.repository.ClientDao
import ro.asis.green.client.service.repository.ClientRepository

@Service
@ThreadSafe
class ClientService(
    private val clientRepository: ClientRepository,
    private val clientAccountRepository: ClientAccountRepository,
    private val clientDao: ClientDao,
    private val clientMapper: ClientMapper,
    private val restTemplate: RestTemplate
) {
    companion object {
        private val LOG = KotlinLogging.logger { }
    }

    fun findAll(filters: ClientFilters): List<ClientDto> = clientMapper.toApi(clientDao.findClients(filters)).toList()

    fun findClient(clientId: String): ClientDto = clientMapper.toApi(
        clientRepository.findById(clientId)
            .orElseThrow { ClientNotFoundException("Could not find client") }
    )

    fun addClient(client: ClientDto): ClientDto = clientMapper.toApi(
        clientRepository.save(
            clientMapper.toEntity(client)
        )
    )

    fun getClientAccount(clientId: String): ClientAccount {
        val client = getOrThrow(clientId);
        val accountDto = fetchAccountForClient(client)

        val clientAccount = ClientAccount(
            client = clientMapper.toApi(client),
            account = accountDto
        )

        return clientAccountRepository.save(clientAccount)
    }

    @LoadBalanced
    private fun fetchAccountForClient(client: ClientEntity): AccountDto {
        return restTemplate.getForObject(
            "http://ACCOUNT-SERVICE/accounts/${client.accountId}",
            AccountDto::class.java
        ) ?: AccountDto()
    }

    fun patchClient(clientId: String, client: ClientDto): ClientDto {
        val dbClient = getOrThrow(clientId)
        copyClient(client, dbClient)

        return clientMapper.toApi(clientRepository.save(dbClient))
    }

    fun deleteClient(clientId: String): ClientDto {
        val clientToDelete = getOrThrow(clientId)
        clientRepository.delete(clientToDelete)
        return clientMapper.toApi(clientToDelete)
    }

    fun getClientCart(clientId: String): Cart {
        val client = getOrThrow(clientId)
        return client.cart
    }

    fun deleteClientCart(clientId: String): ClientDto {
        val client = getOrThrow(clientId)
        client.cart = Cart()
        return clientMapper.toApi(clientRepository.save(client))
    }

    private fun copyClient(newClient: ClientDto, dbClient: ClientEntity) {
        dbClient.firstName = newClient.firstName ?: dbClient.firstName
        dbClient.lastName = newClient.lastName ?: dbClient.lastName
    }

    fun getBagForClient(clientId: String, bagId: String): GreenBag {
        val client = getOrThrow(clientId)
        return client.cart.bags.first { it._id.equals(bagId, ignoreCase = false) }
    }

    fun addBagToCart(clientId: String, bag: GreenBag): ClientDto {
        val client = getOrThrow(clientId)
        client.cart.bags.add(bag)

        return clientMapper.toApi(clientRepository.save(client))
    }

    fun deleteBagFromCart(clientId: String, bagId: String): ClientDto {
        val client = getOrThrow(clientId)
        val clientBag = client.cart.bags.first { it._id.equals(bagId, ignoreCase = false) }
        client.cart.bags.remove(clientBag)
        return clientMapper.toApi(clientRepository.save(client))
    }

    fun getClientAddress(clientId: String): Address {
        val client = getOrThrow(clientId)
        return client.address
    }

    fun deleteClientAddress(clientId: String): ClientDto {
        val dbClient = getOrThrow(clientId)
        dbClient.address = Address()
        return clientMapper.toApi(clientRepository.save(dbClient))
    }

    fun patchClientAddress(clientId: String, address: Address): ClientDto {
        val dbClient = getOrThrow(clientId)
        copyAddress(dbClient.address, address)
        return clientMapper.toApi(clientRepository.save(dbClient))
    }

    private fun copyAddress(dbClientAddress: Address, newAddress: Address) {
        dbClientAddress.building = newAddress.building ?: dbClientAddress.building
        dbClientAddress.city = newAddress.city ?: dbClientAddress.city
        dbClientAddress.flat = newAddress.flat ?: dbClientAddress.flat
        dbClientAddress.floor = newAddress.floor ?: dbClientAddress.floor
        dbClientAddress.staircase = newAddress.staircase ?: dbClientAddress.staircase
        dbClientAddress.streetName = newAddress.streetName ?: dbClientAddress.streetName
        dbClientAddress.streetNumber = newAddress.streetNumber ?: dbClientAddress.streetNumber
        dbClientAddress.zipCode = newAddress.zipCode ?: dbClientAddress.zipCode
    }

    private fun getOrThrow(clientId: String) = clientRepository
        .findById(clientId)
        .orElseThrow { ClientNotFoundException("Could not find client with id $clientId") }
}
