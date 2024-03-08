package com.kopring_basic_api_call.blog.service.impl

import com.kopring_basic_api_call.blog.dto.BlogDto
import com.kopring_basic_api_call.blog.service.BlogService
import com.kopring_basic_api_call.core.exception.ExceptionMsg
import com.kopring_basic_api_call.core.exception.InvalidInputException
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Service
class BlogServiceImpl : BlogService {
    @Value("\${REST_API_KEY}")
    lateinit var restApiKey: String

    override fun searchBlog(blogDto: BlogDto): String? {
        val msgList = mutableListOf<ExceptionMsg>()
        if (blogDto.query.trim().isEmpty()) {
            msgList.add(ExceptionMsg.EMPTY_QUERY)
        }
        if (blogDto.sort.trim() !in arrayOf("accuracy","recency")) {
            msgList.add(ExceptionMsg.NOT_IN_SORT)
        }
        when {
            blogDto.page < 1 -> msgList.add(ExceptionMsg.LESS_THAN_MIN)
            blogDto.page > 50 -> msgList.add(ExceptionMsg.MORE_THAN_MAX)
        }
        if (msgList.isNotEmpty()) {
            val message = msgList.joinToString { it.msg }
            throw InvalidInputException(message)
        }

        val webClient: WebClient = WebClient
            .builder()
            .baseUrl("https://dapi.kakao.com")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()

        val response = webClient
            .get()
            .uri {
                it.path("/v2/search/blog")
                    .queryParam("query", blogDto.query)
                    .queryParam("sort", blogDto.sort)
                    .queryParam("page", blogDto.page)
                    .queryParam("size", blogDto.size)
                    .build()
            }
            .header("Authorization", "KakaoAK 9ca8d7561e020f4fa4ee6b029d009c81")
            .retrieve()
            .bodyToMono<String>()

        return response.block()
    }
}