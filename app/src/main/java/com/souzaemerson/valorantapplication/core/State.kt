package com.souzaemerson.valorantapplication.core

data class State<out T>(
    val status: Status,
    val loading: Boolean?,
    val error: Throwable?,
    val data: T?
) {

    companion object {
        fun <T> success(data: T?): State<T> =
            State(Status.SUCCESS, false, null, data)

        fun <T> loading(loading: Boolean?): State<T> =
            State(Status.LOADING, true, null, null)

        fun <T> error(error: Throwable?): State<T> =
            State(Status.ERROR, false, error, null)
    }
}