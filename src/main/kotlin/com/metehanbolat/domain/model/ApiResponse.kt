package com.metehanbolat.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success: Boolean
)
