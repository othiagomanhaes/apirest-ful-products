package com.thiago.apirestfulproducts.model

import java.util.*

data class ProductResponse(

    val id: Long,

    val name: String,

    val price: Double,

    val quantity: Int,

    val createdAt: Date?,

    val updatedAt: Date?
)
