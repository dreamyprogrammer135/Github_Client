package com.dreamyprogrammer.githubclient

import android.app.Application
import com.dreamyprogrammer.githubclient.domain.UsersRepo
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router


    val usersRepo = UsersRepo()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}