package com.iman.memorize.generic_pattern

interface BaseView<T> {
    fun setPresenter(presenter: T)
}