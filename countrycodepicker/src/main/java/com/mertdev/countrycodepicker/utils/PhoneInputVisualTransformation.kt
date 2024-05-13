package com.mertdev.countrycodepicker.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class PhoneInputVisualTransformation(private var format: String) : VisualTransformation {
    private val maxLength: Int

    init {
        val significantStartIndex = format.indexOfFirst { it == '-' || it == '(' || it == ' ' }
        if (significantStartIndex > 0) {
            format = format.substring(significantStartIndex)
        }
        format = format.replace('.', '#')
        maxLength = format.count { it == '#' }
    }

    override fun filter(text: AnnotatedString): TransformedText {
        val digitsOnly = text.text.filter { it.isDigit() }.take(maxLength)
        var formattedText = ""
        var digitIndex = 0
        var formatIndex = 0

        while (formatIndex < format.length && digitIndex < digitsOnly.length) {
            when (val formatChar = format[formatIndex]) {
                '#' -> {
                    formattedText += digitsOnly[digitIndex]
                    digitIndex++
                }

                else -> formattedText += formatChar
            }
            formatIndex++
        }

        return TransformedText(AnnotatedString(formattedText), object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                var transformedOffset = 0
                var originalOffset = 0

                while (originalOffset < offset && originalOffset < digitsOnly.length) {
                    if (format[transformedOffset] == '#') {
                        originalOffset++
                    }
                    transformedOffset++
                }

                return transformedOffset
            }

            override fun transformedToOriginal(offset: Int): Int {
                var transformedOffset = 0
                var originalOffset = 0

                while (transformedOffset < offset && originalOffset < digitsOnly.length) {
                    if (format[transformedOffset] == '#') {
                        originalOffset++
                    }
                    transformedOffset++
                }

                return originalOffset
            }
        })
    }
}