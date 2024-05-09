package com.mertdev.countrycodepicker.utils

import android.content.Context
import com.mertdev.countrycodepicker.model.Country
import kotlinx.serialization.json.Json

private val json = Json { ignoreUnknownKeys = true }

fun loadCountries(context: Context): List<Country> {
    val jsonText = context.assets.open("country.json").bufferedReader().use { it.readText() }
    return json.decodeFromString(jsonText)
}