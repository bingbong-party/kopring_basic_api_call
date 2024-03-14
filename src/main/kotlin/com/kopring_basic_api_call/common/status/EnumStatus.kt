package com.kopring_basic_api_call.common.status

enum class Gender(val desc: String) {
    MAN("남"),
    WOMAN("여"),
}

enum class ResultCode(val msg: String) {
    SUCCESS("정상적으로 처리되었습니다."),
    ERROR("에러가 발생했습니다.")
}