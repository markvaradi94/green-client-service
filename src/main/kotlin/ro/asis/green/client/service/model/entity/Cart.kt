package ro.asis.green.client.service.model.entity

data class Cart(
    var bags: MutableList<GreenBag> = mutableListOf()

    //TODO write PaymentMethod
    //TODO add a cartTotal to the class?
)

