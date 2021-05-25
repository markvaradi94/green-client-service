package ro.asis.green.client.service.bootstrap

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ro.asis.green.client.service.model.entity.Address
import ro.asis.green.client.service.model.entity.Cart
import ro.asis.green.client.service.model.entity.ClientEntity
import ro.asis.green.client.service.model.entity.GreenBag
import ro.asis.green.client.service.service.ClientService

@Component
class DataLoader(private val clientService: ClientService) : CommandLineRunner {
    override fun run(vararg args: String?) {
//        clientService.addClient(
//            ClientEntity(
//                accountId = "cadin7",
//                firstName = "Mark",
//                lastName = "Erdei",
//                addresses = listOf(
//                    Address(
//                        city = "Oradea",
//                        zipCode = "31934217",
//                        streetName = "Primariei",
//                        streetNumber = "44V",
//                        building = "AN2",
//                        staircase = "Z",
//                        floor = 5,
//                        flat = "23"
//                    )
//                ),
//                cart = Cart(
//                    bags = mutableListOf(
//                        GreenBag(
//                            description = "Pizza",
//                            price = 20.0
//                        ),
//                        GreenBag(
//                            description = "Fresh fruits and vegetables",
//                            price = 25.5
//                        )
//                    )
//                )
//            )
//        )
//        clientService.addClient(
//            ClientEntity(
//                accountId = "markv",
//                firstName = "Mark",
//                lastName = "Varadi",
//                addresses = listOf(
//                    Address(
//                        city = "Oradea",
//                        zipCode = "123521",
//                        streetName = "Dacia",
//                        streetNumber = "4Z",
//                        building = "AN19",
//                        staircase = "X5",
//                        floor = 2,
//                        flat = "7"
//                    )
//                ),
//                cart = Cart(
//                    bags = mutableListOf(
//                        GreenBag(
//                            description = "Miscellaneous items from buffet",
//                            price = 30.0
//                        ),
//                        GreenBag(
//                            description = "Apple pie",
//                            price = 15.25
//                        ),
//                        GreenBag(
//                            description = "Cheese and Ham Bagel",
//                            price = 17.0
//                        )
//                    )
//                )
//            )
//        )
    }
}
