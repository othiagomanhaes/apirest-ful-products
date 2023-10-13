package com.thiago.apirestfulproducts.repository

import com.thiago.apirestfulproducts.entities.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository: JpaRepository<ApiKey, Long> {
}