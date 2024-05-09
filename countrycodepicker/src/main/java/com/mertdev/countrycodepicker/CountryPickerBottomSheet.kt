package com.mertdev.countrycodepicker

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.mertdev.countrycodepicker.model.Country
import com.mertdev.countrycodepicker.utils.ResourceUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryPickerModalBottomSheet(
    modifier: Modifier = Modifier,
    countries: List<Country>,
    onCountrySelected: (Country) -> Unit,
    onDismiss: () -> Unit,
    containerColor: Color = BottomSheetDefaults.ContainerColor,
    contentColor: Color = contentColorFor(containerColor),
    scrimColor: Color = BottomSheetDefaults.ScrimColor,
    skipPartiallyExpanded: Boolean = false,
    searchField: (@Composable (String, (String) -> Unit) -> Unit)? = null,
    titleContent: @Composable (() -> Unit)? = null,
    closeIcon: ImageVector? = null,
    countryItemNameTextStyle: TextStyle = LocalTextStyle.current,
    countryIDialCodeTextStyle: TextStyle = LocalTextStyle.current
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = skipPartiallyExpanded)
    var searchQuery by remember { mutableStateOf("") }
    val filteredCountries = remember(searchQuery) {
        countries.filter {
            it.name.contains(searchQuery, ignoreCase = true) || it.dialCode.contains(
                searchQuery, ignoreCase = true
            )
        }
    }

    ModalBottomSheet(sheetState = sheetState,
        onDismissRequest = {
            onDismiss()
        },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (titleContent != null) {
                        titleContent.invoke()
                    } else {
                        Spacer(Modifier.weight(1f))
                    }
                    closeIcon?.let {
                        IconButton(onClick = { onDismiss() }) {
                            Icon(imageVector = it, contentDescription = "Close")
                        }
                    } ?: Spacer(Modifier.weight(1f))

                }
                if (searchField != null) {
                    searchField(searchQuery) { query ->
                        searchQuery = query
                    }
                }
                LazyColumn {
                    items(filteredCountries) { country ->
                        CountryItem(
                            country = country,
                            onCountrySelected = {
                                onCountrySelected(country)
                            },
                            countryItemNameTextStyle = countryItemNameTextStyle,
                            countryIDialCodeTextStyle = countryIDialCodeTextStyle
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        },
        containerColor = containerColor,
        contentColor = contentColor,
        scrimColor = scrimColor,
        dragHandle = null,
        modifier = modifier.navigationBarsPadding()
    )
}

@Composable
fun CountryItem(
    country: Country,
    onCountrySelected: (Country) -> Unit,
    countryItemNameTextStyle: TextStyle,
    countryIDialCodeTextStyle: TextStyle
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onCountrySelected(country) }
            .padding(16.dp)
            .fillMaxWidth()) {
        val imageId = ResourceUtil.getImageResource(country.image)
        val painter = painterResource(id = imageId)
        Image(
            painter = painter,
            contentDescription = "${country.name} flag",
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = country.name, style = countryItemNameTextStyle)
            Text(text = country.dialCode, style = countryIDialCodeTextStyle)
        }
    }
}