package com.kopring_basic_api_call.core.exception

import java.lang.RuntimeException

class InvalidInputException (
    massage: String = "Invalid Input"
) : RuntimeException(massage)