package com.mumbicodes.fibonacci.presentation.searchNumber

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mumbicodes.fibonacci.domain.model.FibonacciSearch
import com.mumbicodes.fibonacci.presentation.components.FibonacciCardComposable
import com.mumbicodes.fibonacci.presentation.components.SearchFieldComposable
import com.mumbicodes.fibonacci.presentation.util.provideShadowColor

@Composable
fun SearchScreen(
    viewModel: SearchNumberViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    val searchParam = viewModel.searchParamState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = "Search Fibonacci numbers",
            style = MaterialTheme.typography.headlineLarge.copy(color = MaterialTheme.colorScheme.onSurface),
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        Row {
            SearchFieldComposable(
                modifier = Modifier
                    .weight(1f)
                    .clip(
                        MaterialTheme.shapes.small
                    ),
                searchedText = searchParam,
                onSearchParamChanged = { searchParam ->
                    viewModel.updateSearchParameter(searchParam)
                }
            )

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    viewModel.calculateArbitraryNumbers(searchParam)
                },
                modifier = Modifier
                    .widthIn()
                    .height(54.dp),
                shape = MaterialTheme.shapes.small,
                enabled = searchParam.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    disabledContentColor = MaterialTheme.colorScheme.onPrimary
                ),
            ) {
                Text(
                    text = "Search",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        when (state.value) {
            is FibonacciUiState.Data -> {
                PreviousSearches((state.value as FibonacciUiState.Data).data)
            }
            FibonacciUiState.Loading -> {
                // TODO
                Log.e("State", "Loading")
            }
            is FibonacciUiState.SearchResult -> {
                SearchResults((state.value as FibonacciUiState.SearchResult).result)
            }
        }
    }
}

@Composable
fun SearchResults(fibonacciSearch: FibonacciSearch) {
    Column {
        Text(
            text = "Search results",
            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        FibonacciCardComposable(
            modifier = Modifier
                .shadow(
                    elevation = 16.dp,
                    shape = MaterialTheme.shapes.small,
                    ambientColor = provideShadowColor(),
                    spotColor = provideShadowColor()
                )
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = MaterialTheme.shapes.small
                )
                .padding(12.dp),
            fibonacciSearch = fibonacciSearch
        )
    }
}

@Composable
fun PreviousSearches(fibonacciSearches: List<FibonacciSearch>) {
    Column {
        Row {
            Text(
                text = "Recent searches",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface),
                modifier = Modifier
                    .weight(1f)
            )

            Spacer(modifier = Modifier.width(24.dp))

            Text(
                text = "Clear All",
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable(
                        onClick = {
                            TODO()
                        }
                    )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(fibonacciSearches) { _, fibonacciSearches ->
                FibonacciCardComposable(
                    modifier = Modifier
                        .shadow(
                            elevation = 16.dp,
                            shape = MaterialTheme.shapes.small,
                            ambientColor = provideShadowColor(),
                            spotColor = provideShadowColor()
                        )
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.small
                        )
                        .padding(12.dp),
                    fibonacciSearch = fibonacciSearches
                )
            }
        }
    }
}