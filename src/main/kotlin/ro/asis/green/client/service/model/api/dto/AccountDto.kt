package ro.asis.green.client.service.model.api.dto

import ro.asis.green.client.service.model.api.enums.AccountRole
import ro.asis.green.client.service.model.api.enums.AccountRole.USER
import ro.asis.green.client.service.model.api.enums.AccountType
import ro.asis.green.client.service.model.api.enums.AccountType.CLIENT

data class AccountDto(
    var id: String = "0",
    var username: String = "",
    var password: String = "",
    var email: String = "",
    var phoneNumber: String = "",
    var type: AccountType = CLIENT,
    var role: AccountRole = USER
)
