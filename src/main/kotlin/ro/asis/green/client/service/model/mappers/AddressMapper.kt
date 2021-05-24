package ro.asis.green.client.service.model.mappers

import org.springframework.stereotype.Component
import ro.asis.green.client.service.model.api.dto.AddressDto
import ro.asis.green.client.service.model.entity.Address

@Component
class AddressMapper : Mapper<AddressDto, Address> {
    override fun toApi(source: Address): AddressDto {
        return AddressDto(
            city = source.city,
            zipCode = source.zipCode,
            streetName = source.streetName,
            streetNumber = source.streetNumber,
            building = source.building,
            staircase = source.staircase,
            floor = source.floor,
            flat = source.flat
        )
    }

    override fun toEntity(source: AddressDto): Address {
        return Address(
            city = source.city,
            zipCode = source.zipCode,
            streetName = source.streetName,
            streetNumber = source.streetNumber,
            building = source.building,
            staircase = source.staircase,
            floor = source.floor,
            flat = source.flat
        )
    }
}
