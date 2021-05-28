package ro.asis.green.client.service.repository

import org.springframework.data.mongodb.repository.MongoRepository
import ro.asis.green.client.service.model.entity.ClientAccount

interface ClientAccountRepository : MongoRepository<ClientAccount, String>
