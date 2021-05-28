package ro.asis.green.client.service.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import ro.asis.green.client.service.model.entity.ClientEntity

@Repository
interface ClientRepository : MongoRepository<ClientEntity, String> {
}
