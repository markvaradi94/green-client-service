package ro.asis.green.client.service.model.mappers

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import ro.asis.green.client.service.model.api.dto.ClientDto
import ro.asis.green.client.service.model.entity.ClientEntity

@Component
@RequiredArgsConstructor
class ClientMapper(
    private val addressMapper: AddressMapper
) : Mapper<ClientDto, ClientEntity> {

    //TODO write mapper interface or microservice to map all entities to DTO and back

    override fun toApi(source: ClientEntity): ClientDto {
        return ClientDto(
            id = source.id,
            accountId = source.accountId,
            firstName = source.firstName,
            lastName = source.lastName,
            addresses = addressMapper.toApi(source.addresses) ?: listOf(),
            cart = source.cart
        )
    }

    override fun toEntity(source: ClientDto): ClientEntity {
        return ClientEntity(
            id = source.id,
            accountId = source.accountId,
            firstName = source.firstName,
            lastName = source.lastName,
            addresses = addressMapper.toEntity(source.addresses) ?: listOf(),
            cart = source.cart
        )
    }
}
