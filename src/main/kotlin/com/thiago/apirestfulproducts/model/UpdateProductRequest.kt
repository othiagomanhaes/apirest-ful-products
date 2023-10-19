package com.thiago.apirestfulproducts.model

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UpdateProductRequest(

    @field:NotBlank
    val name: String?,

    @field:NotNull
    @field:Min(1)
    val price: Double?,

    @field:NotNull
    @field:Min(0)
    val quantity: Int?
)
