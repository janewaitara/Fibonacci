package com.mumbicodes.fibonacci.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mumbicodes.fibonacci.R
import com.mumbicodes.fibonacci.presentation.util.provideShadowColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchFieldComposable(
    modifier: Modifier = Modifier,
    searchedText: String = "",
    onSearchParamChanged: (String) -> Unit = {},
) {
    Surface(
        modifier = modifier
            .shadow(
                elevation = 60.dp,
                ambientColor = provideShadowColor(),
                spotColor = provideShadowColor()
            )
            .background(color = MaterialTheme.colorScheme.surface),
        shape = MaterialTheme.shapes.small,
    ) {
        TextField(
            value = searchedText,
            onValueChange = {
                if (it.isNotEmpty()) {
                    onSearchParamChanged(
                        it.filter { symbol ->
                            symbol.isDigit()
                        }
                    )
                }
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.alpha(0.5f),
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.surface,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    modifier = Modifier.alpha(0.5f), // reduces the opacity
                    text = stringResource(R.string.search_placeHolder),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall
                )
            },
            textStyle = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.inverseSurface),

            singleLine = true,

            modifier = modifier
                .padding(0.dp)
                .heightIn(min = 48.dp)
        )
    }
}
