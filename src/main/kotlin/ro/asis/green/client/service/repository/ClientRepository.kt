package ro.asis.green.client.service.repository

import org.springframework.data.mongodb.repository.MongoRepository
import ro.asis.green.client.service.model.entity.ClientEntity

interface ClientRepository : MongoRepository<ClientEntity, String> {
}
