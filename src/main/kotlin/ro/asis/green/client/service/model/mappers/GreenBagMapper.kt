package ro.asis.green.client.service.model.mappers

import org.springframework.stereotype.Component
import ro.asis.green.client.service.model.api.dto.GreenBagDto
import ro.asis.green.client.service.model.entity.GreenBag

@Component
class GreenBagMapper : Mapper<GreenBagDto, GreenBag> {
    override fun toApi(source: GreenBag): GreenBagDto {
        return GreenBagDto(
            description = source.description,
            price = source.price,
            imageUrl = source.imageUrl
        )
    }

    override fun toEntity(source: GreenBagDto): GreenBag {
        return GreenBag(
            description = source.description,
            price = source.price,
            imageUrl = source.imageUrl
        )
    }
}
