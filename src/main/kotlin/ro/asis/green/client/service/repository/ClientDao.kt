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
        val query = Query()
        val criteria = buildCriteria(filters)

        if (criteria.isNotEmpty()) query.addCriteria(Criteria().andOperator(*criteria.toTypedArray()))

        return mongo.find(query, ClientEntity::class.java)
    }

    private fun buildCriteria(filters: ClientFilters): List<Criteria> {
        val criteria = mutableListOf<Criteria>()

        ofNullable(filters.firstName).ifPresent { criteria.add(Criteria.where("firstName").`is`(it)) }
        ofNullable(filters.lastName).ifPresent { criteria.add(Criteria.where("lastName").`is`(it)) }
        ofNullable(filters.city).ifPresent { criteria.add(Criteria.where("address.city").`is`(it)) }
        ofNullable(filters.streetNumber).ifPresent { criteria.add(Criteria.where("address.streetNumber").`is`(it)) }
        ofNullable(filters.streetName).ifPresent { criteria.add(Criteria.where("address.streetName").`is`(it)) }

        return criteria
    }
}
