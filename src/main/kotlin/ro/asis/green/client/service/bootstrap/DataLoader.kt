package ro.asis.green.client.service.bootstrap

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ro.asis.green.client.service.service.ClientService

@Component
class DataLoader(private val clientService: ClientService) : CommandLineRunner {
    override fun run(vararg args: String?) {
//        clientService.addClient(
//            ClientEntity(
//                id = "123",
//                accountId = "234",
//                firstName = "Mark",
//                lastName = "Varadi"
//            )
//        )
    }
}
