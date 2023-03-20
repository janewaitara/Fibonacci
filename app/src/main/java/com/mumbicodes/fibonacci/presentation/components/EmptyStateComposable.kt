package com.mumbicodes.fibonacci.presentation.components

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mumbicodes.fibonacci.R
import com.mumbicodes.fibonacci.presentation.theme.FibonacciTheme

@Composable
fun EmptyStateComposable(
    modifier: Modifier = Modifier,
    @DrawableRes illustration: Int = R.drawable.ic_search_illustration,
    @StringRes title: Int = R.string.search_heading,
    @StringRes description: Int = R.string.search_Desc,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            modifier = Modifier.height(200.dp),
            painter = painterResource(id = illustration),
            contentDescription = "Empty state illustration"
        )

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(title),
            style = MaterialTheme.typography.headlineLarge.copy(
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Medium,
            ),
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.padding(start = 32.dp, end = 32.dp),
            text = stringResource(description),
            style = MaterialTheme.typography.bodyMedium.copy(
                MaterialTheme.colorScheme.inverseSurface,
                fontWeight = FontWeight.Medium
            ),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun EmptyStatePreview() {
    FibonacciTheme() {
        EmptyStateComposable()
    }
}
