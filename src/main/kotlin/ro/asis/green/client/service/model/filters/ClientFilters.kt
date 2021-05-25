package ro.asis.green.client.service.model.filters

data class ClientFilters(
    var firstName: String? = null,
    var lastName: String? = null,
    var city: String? = null,
    var streetName: String? = null,
    var streetNumber: String? = null
)
