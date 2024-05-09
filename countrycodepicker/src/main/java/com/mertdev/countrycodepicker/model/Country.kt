package com.mertdev.countrycodepicker.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val name: String,
    val code: String,
    val emoji: String,
    val unicode: String,
    val image: String,
    @SerialName("dial_code") val dialCode: String,
    @SerialName("phone_format") val phoneFormat: String
)