package com.dreamyprogrammer.githubclient.domain

interface IItemView {
    var pos: Int
}

interface UserItemView : IItemView {
    fun setLogin(text: String)
}