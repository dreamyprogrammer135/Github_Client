package com.dreamyprogrammer.githubclient.domain

import android.os.Parcelable
//import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    val login: String,
//    @SerializedName("avatar_url")
//    val avatar: String,
//    @SerializedName("repos_url")
//    val repos: String
): Parcelable