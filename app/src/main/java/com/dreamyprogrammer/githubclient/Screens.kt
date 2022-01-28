package com.dreamyprogrammer.githubclient

import com.dreamyprogrammer.githubclient.userlist.UserListFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class Screens : IScreens {
    override fun userList() = FragmentScreen { UserListFragment.newInstance() }
}

interface IScreens {
    fun userList(): Screen
}