package com.kopring_basic_api_call.common.dto

import com.kopring_basic_api_call.common.status.ResultCode

data class BaseResponse<T>(
        val resultCode: String = ResultCode.SUCCESS.name,
        val data: T? = null,
        val message: String = ResultCode.SUCCESS.msg,
)