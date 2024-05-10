package com.mertdev.countrycodepicker

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mertdev.countrycodepicker.utils.CountryCode
import com.mertdev.countrycodepicker.utils.CountryCodeUtils
import com.mertdev.countrycodepicker.utils.PhoneInputVisualTransformation
import com.mertdev.countrycodepicker.utils.ResourceUtil
import com.mertdev.countrycodepicker.utils.loadCountries

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryCodePicker(
    modifier: Modifier = Modifier,
    onFullNumber: (String) -> Unit,
    onPhoneNumberWithoutCountryCode: (String) -> Unit = {},
    onDialCode: (String) -> Unit = {},
    onCountryName: (String) -> Unit = {},
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    placeholder: @Composable (() -> Unit)? = null,
    textStyle: TextStyle = LocalTextStyle.current,
    dialCodeTextStyle: TextStyle = LocalTextStyle.current,
    initialNumber: String = "",
    initialCountryCode: CountryCode = CountryCode.TR,
    showFlag: Boolean = true,
    showDialCode: Boolean = true,
    flagImageSize: Dp = 24.dp,
    shape: Shape = RoundedCornerShape(5.dp),
    pickerRowPadding: PaddingValues = PaddingValues(horizontal = 12.dp),
    pickerRowDialCodePadding: PaddingValues = PaddingValues(start = 4.dp),
    bottomSheetModalModifier: Modifier = Modifier,
    bottomSheetContainerColor: Color = BottomSheetDefaults.ContainerColor,
    bottomSheetContentColor: Color = contentColorFor(bottomSheetContainerColor),
    bottomSheetScrimColor: Color = BottomSheetDefaults.ScrimColor,
    skipPartiallyExpanded: Boolean = false,
    bottomSheetSearchField: (@Composable (String, (String) -> Unit) -> Unit)? = null,
    bottomSheetTitleContent: @Composable (() -> Unit)? = null,
    bottomSheetCloseIcon: ImageVector? = null,
    countryItemNameTextStyle: TextStyle = LocalTextStyle.current,
    countryIDialCodeTextStyle: TextStyle = LocalTextStyle.current,
) {
    val context = LocalContext.current
    val countries = remember { loadCountries(context) }
    val defaultCountry = remember {
        countries.find { it.code == initialCountryCode.code } ?: countries.first()
    }
    val selectedCountry = remember { mutableStateOf(defaultCountry) }
    var phoneNumber by remember { mutableStateOf(initialNumber) }
    var showBottomSheet by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    val dialCodeCount = selectedCountry.value.dialCode.count {
        it.isDigit()
    }
    val maxLength = selectedCountry.value.phoneFormat.count { it == '.' }.minus(dialCodeCount)

    OutlinedTextField(modifier = modifier,
        shape = shape,
        visualTransformation = PhoneInputVisualTransformation(
            selectedCountry.value.phoneFormat.replace(
                '.', '#'
            )
        ),
        value = phoneNumber,
        onValueChange = { number ->
            val filtered = number.filter { char -> char.isDigit() }
            if (filtered.length <= maxLength) {
                val countryCodeUtils = CountryCodeUtils(selectedCountry.value, filtered)
                phoneNumber = filtered
                onFullNumber(countryCodeUtils.getFullNumber())
                onPhoneNumberWithoutCountryCode(countryCodeUtils.getPhoneNumberWithoutCountryCode())
                onDialCode(countryCodeUtils.getDialCode())
                onCountryName(countryCodeUtils.getCountryName())
            }
        },
        textStyle = textStyle,
        placeholder = placeholder,
        leadingIcon = {
            if (showFlag || showDialCode) {
                Row(
                    modifier = Modifier
                        .clickable(interactionSource = interactionSource,
                            indication = null,
                            onClick = { showBottomSheet = true })
                        .padding(pickerRowPadding),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (showFlag) {
                        Image(
                            painter = painterResource(
                                id = ResourceUtil.getImageResource(
                                    selectedCountry.value.image
                                )
                            ),
                            contentScale = ContentScale.Crop,
                            contentDescription = "Flag",
                            modifier = Modifier
                                .size(flagImageSize)
                                .clip(CircleShape)
                        )
                    }
                    if (showDialCode) {
                        Text(
                            text = selectedCountry.value.dialCode,
                            style = dialCodeTextStyle,
                            modifier = Modifier.padding(pickerRowDialCodePadding)
                        )
                    }
                }
            }
        },
        singleLine = true,
        colors = colors,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    if (showBottomSheet) {
        CountryPickerModalBottomSheet(modifier = bottomSheetModalModifier,
            countries = countries,
            onCountrySelected = {
                selectedCountry.value = it
                showBottomSheet = false
                phoneNumber = ""
            },
            onDismiss = {
                showBottomSheet = false
            },
            containerColor = bottomSheetContainerColor,
            contentColor = bottomSheetContentColor,
            scrimColor = bottomSheetScrimColor,
            skipPartiallyExpanded = skipPartiallyExpanded,
            searchField = bottomSheetSearchField,
            titleContent = bottomSheetTitleContent,
            closeIcon = bottomSheetCloseIcon,
            countryItemNameTextStyle = countryItemNameTextStyle,
            countryIDialCodeTextStyle = countryIDialCodeTextStyle
        )
    }
}