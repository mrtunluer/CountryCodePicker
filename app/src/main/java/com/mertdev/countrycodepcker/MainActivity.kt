package com.mertdev.countrycodepcker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mertdev.countrycodepicker.CountryCodePicker
import com.mertdev.countrycodepicker.utils.CountryCode

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                CountryCodePicker(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp),
                    onFullNumber = { fullNumber ->
                        println("Full Number: $fullNumber")
                    },
                    onPhoneNumberWithoutCountryCode = { numberWithoutCode ->
                        println("Number without Country Code: $numberWithoutCode")
                    },
                    onDialCode = { dialCode ->
                        println("Dial Code: $dialCode")
                    },
                    bottomSheetTitleContent = {
                        Text(text = "Select Country", fontSize = 16.sp)
                    },
                    bottomSheetCloseIcon = Icons.Filled.Close,
                    onCountryName = { countryName ->
                        println("Country Name: $countryName")
                    },
                    placeholder = { Text(text = "Phone Number") },
                    initialCountryCode = CountryCode.TR,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Black,
                        focusedContainerColor = Color.White,
                        focusedTextColor = Color.Black,
                        unfocusedBorderColor = Color.DarkGray
                    ),
                    dialCodeTextStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
                    bottomSheetSearchField = { searchQuery, onQueryChanged ->
                        OutlinedTextField(value = searchQuery,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp),
                            onValueChange = onQueryChanged,
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.Black,
                                focusedContainerColor = Color.White,
                                focusedTextColor = Color.Black,
                                unfocusedBorderColor = Color.DarkGray
                            ),
                            placeholder = { Text("Search countries...") })
                    })
            }
        }
    }
}