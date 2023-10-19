package com.thiago.apirestfulproducts.service.impl

import com.thiago.apirestfulproducts.entities.Product
import com.thiago.apirestfulproducts.model.CreateProductRequest
import com.thiago.apirestfulproducts.model.ListProductRequest
import com.thiago.apirestfulproducts.model.ProductResponse
import com.thiago.apirestfulproducts.model.UpdateProductRequest
import com.thiago.apirestfulproducts.repository.ProductsRepository
import com.thiago.apirestfulproducts.service.ProductService
import com.thiago.apirestfulproducts.validation.ValidationUtil
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import java.util.*
import java.util.stream.Collectors

class ProductServiceImpl(
    val productsRepository: ProductsRepository,
    val validationUtil: ValidationUtil
): ProductService {
   override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest)

        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price,
            quantity = createProductRequest.quantity,
            createdAt = Date(),
            updatedAt = null
        )

        productsRepository.save(product)
        return convertProductToProductResponse(product)
    }

    override fun get(id: String): ProductResponse {
        val product = findProductByIdOrThrowNotFound(id)
        return convertProductToProductResponse(product)
    }

    override fun delete(id: String) {
        val product = findProductByIdOrThrowNotFound(id)
        productsRepository.delete(product)
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productsRepository.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
        val products = page.get().collect(Collectors.toList())
        return products.map { convertProductToProductResponse(it) }
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        val product = findProductByIdOrThrowNotFound(id)

        validationUtil.validate(product)

        product.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updatedAt = Date()
        }

        productsRepository.save(product)
        return convertProductToProductResponse(product)
    }

    private fun findProductByIdOrThrowNotFound(id: String): Product {
        val product = productsRepository.findByIdOrNull(id)
        if (product == null) {
            throw ChangeSetPersister.NotFoundException()
        } else {
            return product;
        }
    }

    private fun convertProductToProductResponse(product: Product): ProductResponse {
        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }
}