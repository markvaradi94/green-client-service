package ro.asis.green.client.service.model.entity

data class Address(
    var city: String? = null,
    var zipCode: String? = null,
    var streetName: String? = null,
    var streetNumber: String? = null,
    var building: String? = null,
    var staircase: String? = null,
    var floor: Int? = null,
    var flat: String? = null

    //TODO add something to keep trace of the current activeAddress
)
