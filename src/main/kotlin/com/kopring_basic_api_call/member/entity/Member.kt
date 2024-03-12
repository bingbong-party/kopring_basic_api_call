package com.kopring_basic_api_call.member.entity

import com.kopring_basic_api_call.common.status.Gender
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(
    uniqueConstraints = [UniqueConstraint(name = "uk_member_login_id", columnNames = ["loginId"])]
)
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Column(nullable = false, length = 30, updatable = false) // updatable false = update 되어도 로그인 아이디는 제외되도록
    val loginId: String,

    @Column(nullable = false, length = 100)
    val password: String,

    @Column(nullable = false, length = 10)
    val name: String,

    @Column(nullable = false)
    @Temporal(TemporalType.DATE) // 날짜만 입력받음
    val birthDate: LocalDate,

    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING) // enum 이름을 그대로 디비에 저장
    val gender: Gender,

    @Column(nullable = false, length = 30)
    val email: String,
)
