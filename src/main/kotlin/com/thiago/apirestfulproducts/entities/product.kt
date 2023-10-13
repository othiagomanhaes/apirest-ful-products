package com.thiago.apirestfulproducts.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.util.Date

@Entity
@Table(name = "products")
class Product(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotNull
    @field:Size(min = 2, max = 30, message = "Name must be at least 2 and maximum 30 characters")
    var name: String,

    @field:NotNull
    var price: Double,

    @field:NotNull
    var quantity: Long,

    @field:NotNull
    var createdAt: Date,

    @field:NotNull
    var updatedAt: Date?
)