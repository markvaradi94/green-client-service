package ro.asis.green.client.service.model.api.dto

data class ItemDto(
    var name: String? = null,
    var description: String? = null,
    var price: Double? = null,
    var imageUrl: String? = null
)
