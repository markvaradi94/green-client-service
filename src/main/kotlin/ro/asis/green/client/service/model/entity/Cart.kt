package ro.asis.green.client.service.model.entity

data class Cart(
    var bags: List<GreenBag>? = listOf()

    //TODO write PaymentMethod
)

