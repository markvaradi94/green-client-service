package ro.asis.green.client.service.model.api.dto

data class AddressDto(
    var city: String? = null,
    var zipCode: String? = null,
    var streetName: String? = null,
    var streetNumber: String? = null,
    var building: String? = null,
    var staircase: String? = null,
    var floor: Int? = null,
    var flat: String? = null
)
