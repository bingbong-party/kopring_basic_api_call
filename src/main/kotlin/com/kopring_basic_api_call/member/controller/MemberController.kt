package com.kopring_basic_api_call.member.controller

import com.kopring_basic_api_call.member.dto.MemberDtoRequest
import com.kopring_basic_api_call.member.service.MemberService
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
    fun signUp(@RequestBody input: MemberDtoRequest): String {
        return memberService.signUp(input)
    }
}