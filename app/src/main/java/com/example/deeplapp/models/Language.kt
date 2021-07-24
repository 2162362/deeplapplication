package com.example.deeplapp.models

import com.squareup.moshi.Json

data class Language (
    @field:Json(name = "language")
    val Language: String,

    @field:Json(name = "name")
    val Name: String,

    @field:Json(name = "supports_formality")
    val SupportsFormality: Boolean) {
    override fun toString(): String {
        return Name
    }
}