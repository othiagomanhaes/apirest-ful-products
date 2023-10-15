package com.thiago.apirestfulproducts.model

import jakarta.validation.constraints.NotNull

data class CreateProductRequest(

    @field:NotNull
    val id: Long?,

    @field:NotNull
    val name: String?,

    @field:NotNull
    val price: Double,

    @field:NotNull
    val quantity: Long
)
