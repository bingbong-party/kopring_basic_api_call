package com.kopring_basic_api_call.member.controller

import com.kopring_basic_api_call.common.dto.BaseResponse
import com.kopring_basic_api_call.member.dto.MemberDtoRequest
import com.kopring_basic_api_call.member.service.MemberService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/member")
@RestController
class MemberController (
    private val memberService: MemberService
) {
    /**
     * 회원가입
     */
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid input: MemberDtoRequest): BaseResponse<Unit> { // Unit : 비어있는 값임을 명시
        val resultMsg: String = memberService.signUp(input)

        return BaseResponse(message = resultMsg)
    }
}