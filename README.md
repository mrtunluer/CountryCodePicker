# CountryCodePicker

The CountryCodePicker is a customizable Android component designed for easy and efficient country and dial code selection in your Android applications. It utilizes the latest in Android Compose UI elements to provide a smooth and integrated experience.


## Screenshots

![App Screenshot](https://github-production-user-asset-6210df.s3.amazonaws.com/75806927/329186338-4282e7ba-5cf4-474b-8770-1e89315e6a5c.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAVCODYLSA53PQK4ZA%2F20240509%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240509T085121Z&X-Amz-Expires=300&X-Amz-Signature=493199a94ab89eba6565f3b39dc06f9d0b5d665a24d6ad5da787a8694d7b56f8&X-Amz-SignedHeaders=host&actor_id=75806927&key_id=0&repo_id=677483873)


## Usage/Examples

```kotlin
CountryCodePicker(
    modifier = Modifier
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
    }
)
```


## Customize

```kotlin
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
)
```
## Download
To include CountryCodePicker in your project, add the following to your build configuration:
> material3 is required.
<details>
  <summary>Groovy</summary>

  ## settings.gradle
  ```gradle
  maven { url 'https://jitpack.io' }
  ```
  ## build.gradle
  ```gradle
  implementation 'androidx.compose.material3:material3'
  implementation 'com.github.mrtunluer:CountryCodePicker:<latest-version>'
  ```
</details>

<details>
  <summary>Kotlin DSL</summary>

  ## settings.gradle
  ```gradle
  maven { url = uri("https://jitpack.io") }
  ```
  ## build.gradle
  ```gradle
  implementation("androidx.compose.material3:material3")
  implementation("com.github.mrtunluer:CountryCodePicker:<latest-version>")
  ```
</details>
## License

<div align="start"> <h2 align="start">License</h1> </div>

``` xml
Copyright 2024 mrtunluer.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

