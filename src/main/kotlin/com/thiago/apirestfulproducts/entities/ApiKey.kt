package com.thiago.apirestfulproducts.entities

import jakarta.persistence.*

@Entity
@Table(name = "api_keys")
 data class ApiKey(
     @Id
     val id: Long
)