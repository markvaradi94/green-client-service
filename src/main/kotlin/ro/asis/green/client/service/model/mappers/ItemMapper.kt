package ro.asis.green.client.service.model.mappers

import org.springframework.stereotype.Component
import ro.asis.green.client.service.model.api.dto.ItemDto
import ro.asis.green.client.service.model.entity.Item

@Component
class ItemMapper : Mapper<ItemDto, Item> {
    override fun toApi(source: Item): ItemDto {
        return ItemDto(
            name = source.name,
            description = source.description,
            price = source.price,
            imageUrl = source.imageUrl
        )
    }

    override fun toEntity(source: ItemDto): Item {
        return Item(
            name = source.name,
            description = source.description,
            price = source.price,
            imageUrl = source.imageUrl
        )
    }
}
