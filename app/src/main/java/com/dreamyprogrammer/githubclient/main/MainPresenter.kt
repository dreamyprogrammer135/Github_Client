package com.dreamyprogrammer.githubclient.main

import com.dreamyprogrammer.githubclient.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter


class MainPresenter(private val router: Router, private val screens: IScreens) :
    MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.userList())
    }

    fun backClicked() {
        router.exit()
    }
}
