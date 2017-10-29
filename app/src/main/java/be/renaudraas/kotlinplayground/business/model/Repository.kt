package be.renaudraas.kotlinplayground.business.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(
        val id: Long,
        val name: String,
        val description: String?,
        val isPrivate: Boolean,
        val user: User?
) : Parcelable