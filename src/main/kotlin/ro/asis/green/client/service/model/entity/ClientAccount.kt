package ro.asis.green.client.service.model.entity

import lombok.Data
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import ro.asis.green.client.service.model.api.dto.AccountDto
import ro.asis.green.client.service.model.api.dto.ClientDto

@Data
@Document(collection = "client_accounts")
class ClientAccount(
    var id: String = ObjectId.get().toHexString(),
    val client: ClientDto,
    val account: AccountDto
)
