package com.kopring_basic_api_call.member.repository

import com.kopring_basic_api_call.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByLoginId(loginId: String): Member?
}