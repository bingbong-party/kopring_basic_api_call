package com.kopring_basic_api_call.core.response

const val INVALID_ARGUMENT: String = "Invalid Argument"

data class ErrorResponse (
    val message: String,
    val errorType: String = INVALID_ARGUMENT
)