package com.dreamyprogrammer.githubclient.domain

class UsersRepo {

    private val repositories = listOf(
        User("login1"),
        User("login2"),
        User("login3"),
        User("login4"),
        User("login5")
    )

    fun getUsers(): List<User> {
        return repositories
    }

}