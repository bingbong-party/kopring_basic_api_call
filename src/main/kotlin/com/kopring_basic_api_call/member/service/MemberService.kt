package com.kopring_basic_api_call.member.service

import com.kopring_basic_api_call.common.exception.InvalidInputException
import com.kopring_basic_api_call.member.dto.MemberDtoRequest
import com.kopring_basic_api_call.member.entity.Member
import com.kopring_basic_api_call.member.repository.MemberRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class MemberService(
    private val memberRepository: MemberRepository
) {
    /**
     * 회원가입
     */

    fun signUp(memberDtoRequest: MemberDtoRequest): String {
        var member: Member? = memberRepository.findByLoginId(memberDtoRequest.loginId)

        // ID 중복 검사
        if (member != null) {
            throw InvalidInputException("loginId", "이미 등록된 ID 입니다.")
        }

        member = memberDtoRequest.toEntity()

        memberRepository.save(member)

        return "success"
    }
}