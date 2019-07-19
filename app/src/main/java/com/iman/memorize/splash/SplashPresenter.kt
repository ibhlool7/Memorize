package com.iman.memorize.splash

import com.iman.memorize.utils.network.NetworkChecker
import com.iman.memorize.utils.network.NetworkCheckerImpl

class SplashPresenter(private val view: SplashContract.View) :
    SplashContract.Presenter {
    private val networkChecker: NetworkChecker = NetworkCheckerImpl()

    override fun showNetworkResult() {
        val networkState = networkChecker.networkState()
        if (networkState) {
            view.isOnline()
        } else {
            view.isOffline()
        }
    }

    override fun onDestroy() {
    }

    override fun onViewCreated() {
        view.showLoading()
    }

    override fun onFinished() {
    }

}