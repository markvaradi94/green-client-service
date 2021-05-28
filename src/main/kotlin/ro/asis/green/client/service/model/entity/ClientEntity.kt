package ro.asis.green.client.service.model.entity

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Data
@Document(collection = "clients")
class ClientEntity(
    @Id
    var id: String = ObjectId.get().toHexString(),

    val accountId: String? = "",

    @JsonProperty
    var firstName: String? = "",

    @JsonProperty
    var lastName: String? = "",

    var address: Address = Address(),

    var cart: Cart = Cart()
)
