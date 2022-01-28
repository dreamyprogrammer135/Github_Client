package com.dreamyprogrammer.githubclient.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.dreamyprogrammer.githubclient.App
import com.dreamyprogrammer.githubclient.common.BackButtonListener
import com.dreamyprogrammer.githubclient.databinding.FragmentUserListBinding
import com.dreamyprogrammer.githubclient.domain.UsersRepo
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserListFragment : MvpAppCompatFragment(), UserListView, BackButtonListener {

    companion object {
        fun newInstance() = UserListFragment()
    }


    private val presenter: UserListPresenter by moxyPresenter {
        UserListPresenter(
            UsersRepo(),
            App.instance.router
        )
    }
    private var adapter: UserListAdapter? = null

    private var vb: FragmentUserListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUserListBinding.inflate(inflater, container, false).also {
            vb = it
        }.root


    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.usersRecyclerView?.layoutManager = LinearLayoutManager(context)
        adapter = UserListAdapter(presenter.usersListPresenter)
        vb?.usersRecyclerView?.adapter = adapter
    }

    override fun updateUserList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showProgressBar() {
        vb?.loadingLayout?.progressBar?.isVisible = true
    }

    override fun hideProgressBar() {
        vb?.loadingLayout?.progressBar?.isVisible = false
    }

    override fun backPressed() = presenter.backPressed()

}