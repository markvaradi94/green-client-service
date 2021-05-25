package ro.asis.green.client.service.model.api.dto

import ro.asis.green.client.service.model.entity.Cart

data class ClientDto(
    var id: String? = null,
    var accountId: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var addresses: List<AddressDto> = mutableListOf(),
    var cart: Cart? = null
)
