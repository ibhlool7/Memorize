package com.iman.memorize.splash

import com.iman.memorize.generic_pattern.BasePresnter
import com.iman.memorize.generic_pattern.BaseView

interface SplashContract {
    interface Presenter : BasePresnter {
        fun showNetworkResult()
    }
    interface View : BaseView<Presenter>{
        fun isOnline()
        fun isOffline()
        fun showLoading()
    }
}