package com.kopring_basic_api_call.blog.service

import com.kopring_basic_api_call.blog.dto.BlogDto

interface BlogService {
    fun searchBlog(blogDto: BlogDto): String?
}