package com.dreamyprogrammer.githubclient.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    val login: String,
) : Parcelable