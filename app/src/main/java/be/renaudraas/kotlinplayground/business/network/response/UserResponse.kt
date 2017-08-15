package be.renaudraas.kotlinplayground.business.network.response

import be.renaudraas.kotlinplayground.business.model.User

data class UserResponse(
        val id: Long,
        val login: String
)

fun UserResponse.toUser() : User = User(this.id, this.login)