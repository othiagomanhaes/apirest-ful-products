package com.thiago.apirestfulproducts.entities

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "api_keys")
class ApiKey (
    val id: Long
)