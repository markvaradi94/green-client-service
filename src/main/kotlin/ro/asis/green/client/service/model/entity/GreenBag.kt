package ro.asis.green.client.service.model.entity

import org.bson.types.ObjectId

data class GreenBag(
    var _id: String = ObjectId.get().toHexString(),
    var description: String? = null,
    var price: Double? = null,
    var imageUrl: String? = null
)
