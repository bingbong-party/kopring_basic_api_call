package com.kopring_basic_api_call.blog.controller

import com.kopring_basic_api_call.blog.dto.BlogDto
import com.kopring_basic_api_call.blog.service.BlogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/blog")
class BlogController (
    val blogService: BlogService
) {
    @GetMapping
    fun search(@RequestBody blogDto: BlogDto): String? {
        return blogService.searchBlog(blogDto)
    }
}