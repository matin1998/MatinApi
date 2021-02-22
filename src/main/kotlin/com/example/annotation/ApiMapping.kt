package com.example.annotation

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.MediaType

@RestController
@RequestMapping("api",produces = [(MediaType.APPLICATION_JSON_VALUE)])
annotation class ApiMapping
