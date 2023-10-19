package com.thiago.apirestfulproducts.service

import com.thiago.apirestfulproducts.model.CreateProductRequest
import com.thiago.apirestfulproducts.model.ListProductRequest
import com.thiago.apirestfulproducts.model.ProductResponse
import com.thiago.apirestfulproducts.model.UpdateProductRequest

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: Long): ProductResponse

    fun update(id: Long, updateProductRequest: UpdateProductRequest): ProductResponse

    fun delete(id: Long)

    fun list(listProductRequest: ListProductRequest): List<ProductResponse>
}