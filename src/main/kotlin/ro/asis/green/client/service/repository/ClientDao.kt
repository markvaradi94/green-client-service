package ro.asis.green.client.service.repository

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository
import ro.asis.green.client.service.model.entity.ClientEntity
import ro.asis.green.client.service.model.filters.ClientFilters
import java.util.Optional.ofNullable

@Repository
class ClientDao(private val mongo: MongoTemplate) {

    fun findClients(filters: ClientFilters): List<ClientEntity> {
        var query = Query()
        var criteria = buildCriteria(filters)

        if (criteria.isNotEmpty()) query.addCriteria(Criteria().andOperator(*criteria.toTypedArray()))

        return mongo.find(query, ClientEntity::class.java)
    }

    private fun buildCriteria(filters: ClientFilters): List<Criteria> {
        var criteria = mutableListOf<Criteria>()

        ofNullable(filters.firstName).ifPresent { criteria.add(Criteria.where("firstName").`is`(it)) }
        ofNullable(filters.lastName).ifPresent { criteria.add(Criteria.where("lastName").`is`(it)) }

        return criteria
    }
}
