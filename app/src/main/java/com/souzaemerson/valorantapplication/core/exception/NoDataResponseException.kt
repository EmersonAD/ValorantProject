package com.souzaemerson.valorantapplication.core.exception

class NoDataResponseException(override val message: String? = "Response without content"): Exception() {
}