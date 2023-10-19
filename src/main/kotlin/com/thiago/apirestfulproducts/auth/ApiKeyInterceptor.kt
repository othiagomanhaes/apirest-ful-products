package com.thiago.apirestfulproducts.auth

import com.thiago.apirestfulproducts.error.NotFoundException
import com.thiago.apirestfulproducts.error.UnauthorizedException
import com.thiago.apirestfulproducts.repository.ApiKeyRepository
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import java.lang.Exception

@Component
class ApiKeyInterceptor(val apiKeyRepository: ApiKeyRepository): WebRequestInterceptor {

    override fun preHandle(request: WebRequest) {
        val apiKey = request.getHeader("X-Api-Key")
        if (apiKey == null) {
            throw UnauthorizedException()
        }

        if (!apiKeyRepository.existsById(apiKey)) {
            throw NotFoundException()
        }
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {

    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {

    }
}