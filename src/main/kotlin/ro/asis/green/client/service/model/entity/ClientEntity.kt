package ro.asis.green.client.service.model.entity

import lombok.Data
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotNull

@Data
@Document(collection = "clients")
class ClientEntity(
    @Id
    var id: String? = ObjectId.get().toHexString(),

    @NotNull
    val accountId: String?,

    @NotNull
    var firstName: String?,

    @NotNull
    var lastName: String?,

    @NotNull
    var addresses: List<Address>? = mutableListOf(),

    var cart: Cart? = Cart()
)
