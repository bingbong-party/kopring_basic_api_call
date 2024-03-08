package com.kopring_basic_api_call.blog.repository

import com.kopring_basic_api_call.blog.entity.WordCount
import org.springframework.data.repository.CrudRepository

interface WordRepository : CrudRepository<WordCount, String>