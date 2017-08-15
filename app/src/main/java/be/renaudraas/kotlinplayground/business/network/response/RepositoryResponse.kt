package be.renaudraas.kotlinplayground.business.network.response

import be.renaudraas.kotlinplayground.business.model.Repository

data class RepositoryResponse(
        val id: Long,
        val name: String,
        val description: String,
        val isPrivate: Boolean,
        val user: UserResponse?
)

fun RepositoryResponse.toRepository(): Repository {
    return Repository(
            id = this.id,
            name = this.name,
            description = this.description,
            isPrivate = this.isPrivate,
            user = this.user?.toUser()
    )
}