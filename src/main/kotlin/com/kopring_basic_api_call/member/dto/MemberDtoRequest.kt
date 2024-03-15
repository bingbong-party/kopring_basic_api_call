package com.kopring_basic_api_call.member.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.kopring_basic_api_call.common.annotation.ValidEnum
import com.kopring_basic_api_call.common.status.Gender
import com.kopring_basic_api_call.member.entity.Member
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class MemberDtoRequest (
    val id: Long?,

    @field:NotBlank
    @JsonProperty("loginId")
    private val _loginId: String?,

    @field:NotBlank
    @JsonProperty("password")
    @field:Pattern(
            regexp="^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#\$%^&*])[a-zA-Z0-9!@#\$%^&*]{8,20}\$",
            message = "영문, 숫자, 특수문자를 포함한 8~20자리로 입력해주세요"
    )
    private val _password: String?,

    @field:NotBlank
    @JsonProperty("name")
    private val _name: String?,

    @field:NotBlank
    @JsonProperty("birthDate")
    @field:Pattern(
            regexp = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$",
            message = "날짜형식(YYYY-MM-DD)을 확인해주세요"
    )
    private val _birthDate: String?,

    @field:NotBlank
    @JsonProperty("gender")
    @ValidEnum(enumClass = Gender::class, message = "MAN 이나 WOMAN 중에 하나를 선택해주세요")
    private val _gender: String?,

    @field:NotBlank
    @field:Email
    @JsonProperty("email")
    private val _email: String?
) {
    // custom getter
    val loginId: String
        get() = _loginId!!
    val password: String
        get() = _password!!
    val name: String
        get() = _name!!
    val birthDate: LocalDate
        get() = _birthDate!!.toLocalDate()

    val gender: Gender
        get() = Gender.valueOf(_gender!!)

    val email: String
        get() = _email!!

    private fun String.toLocalDate(): LocalDate =
            // 아래 this 는 위 'String' 을 의미한다.
            LocalDate.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    fun toEntity(): Member =
            Member(id, loginId, password, name, birthDate, gender, email)
}