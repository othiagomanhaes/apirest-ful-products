package com.thiago.apirestfulproducts.repository

import com.thiago.apirestfulproducts.entities.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductsRepository: JpaRepository<Product, Long> {
}