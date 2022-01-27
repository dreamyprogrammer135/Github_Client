package com.dreamyprogrammer.githubclient.userlist

import com.dreamyprogrammer.githubclient.common.ProgressView
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserListView : MvpView, ProgressView {
    fun init()
    fun updateUserList()
}