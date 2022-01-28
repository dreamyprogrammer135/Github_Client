package com.dreamyprogrammer.githubclient.common

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProgressView {
    fun showProgressBar()
    fun hideProgressBar()
}