package ro.asis.green.client.service.model.api.dto

import org.bson.types.ObjectId
import ro.asis.green.client.service.model.entity.Address
import ro.asis.green.client.service.model.entity.Cart

data class ClientDto(
    var id: String = ObjectId.get().toHexString(),
    var accountId: String?,
    var firstName: String?,
    var lastName: String?,
    var address: Address?,
    var cart: Cart?,
)
