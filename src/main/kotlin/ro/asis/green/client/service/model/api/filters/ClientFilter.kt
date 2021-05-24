package ro.asis.green.client.service.model.api.filters

import ro.asis.green.client.service.model.api.dto.AddressDto
import ro.asis.green.client.service.model.entity.Cart

data class ClientFilter(
    var id: String,
    var firstName: String,
    var lastName: String,
    var email: String,
    var phoneNumber: String,
    var address: AddressDto,
    var cart: Cart
)
