package com.kopring_basic_api_call.common.exception

class InvalidInputException(
        val fieldName: String = "",
        message: String = "Invalid Input"
) : RuntimeException(message) // 상속