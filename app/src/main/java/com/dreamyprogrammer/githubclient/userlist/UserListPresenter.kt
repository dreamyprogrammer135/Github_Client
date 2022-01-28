package com.dreamyprogrammer.githubclient.userlist

import com.dreamyprogrammer.githubclient.domain.IUserListPresenter
import com.dreamyprogrammer.githubclient.domain.User
import com.dreamyprogrammer.githubclient.domain.UserItemView
import com.dreamyprogrammer.githubclient.domain.UsersRepo
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserListPresenter(private val usersRepo: UsersRepo, private val router: Router) :
    MvpPresenter<UserListView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<User>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.showProgressBar()
        loadData()
    }

    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.hideProgressBar()
        usersListPresenter.itemClickListener = { itemView ->

        }
        viewState.updateUserList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}

