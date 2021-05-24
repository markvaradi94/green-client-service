package ro.asis.green.client.service.service

import org.springframework.stereotype.Service
import ro.asis.green.client.service.exceptions.ClientNotFoundException
import ro.asis.green.client.service.model.entity.ClientEntity
import ro.asis.green.client.service.model.filters.ClientFilters
import ro.asis.green.client.service.repository.ClientDao
import ro.asis.green.client.service.repository.ClientRepository

@Service
class ClientService(
    private val clientRepository: ClientRepository,
    private val clientDao: ClientDao
) {
    fun findAll(filters: ClientFilters) = clientDao.findClients(filters)

    fun findById(clientId: String) = clientRepository.findById(clientId)

    fun addClient(client: ClientEntity) = clientRepository.save(client)

    fun updateClient(clientId: String, newClient: ClientEntity): ClientEntity {
        var clientToUpdate = getOrThrow(clientId)
        clientToUpdate.addresses = newClient.addresses
        clientToUpdate.firstName = newClient.firstName
        clientToUpdate.lastName = newClient.lastName
        return clientRepository.save(clientToUpdate)
    }

    fun deleteById(clientId: String): ClientEntity {
        val clientToDelete = getOrThrow(clientId)
        clientRepository.delete(clientToDelete)
        return clientToDelete
    }

    private fun getOrThrow(clientId: String) = clientRepository
        .findById(clientId)
        .orElseThrow { ClientNotFoundException("Could not find client with id $clientId") }
}
