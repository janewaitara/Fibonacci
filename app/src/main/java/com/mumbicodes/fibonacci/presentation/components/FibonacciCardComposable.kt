package com.mumbicodes.fibonacci.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.mumbicodes.fibonacci.domain.model.FibonacciSearch
import com.mumbicodes.fibonacci.presentation.theme.FibonacciTheme
import com.mumbicodes.fibonacci.presentation.util.toDateString

@Composable
fun FibonacciCardComposable(
    modifier: Modifier = Modifier,
    fibonacciSearch: FibonacciSearch,
) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        // Create references for the composables to constrain
        val (searchedNumber, timeSearched, result) = createRefs()

        Text(
            modifier = Modifier
                .constrainAs(searchedNumber) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            text = "Searched: ${fibonacciSearch.searchedNumber}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            modifier = Modifier
                .constrainAs(timeSearched) {
                    start.linkTo(searchedNumber.end, margin = 16.dp)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)

                    width = Dimension.fillToConstraints
                },
            text = fibonacciSearch.timeSearched.toDateString(),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.inverseOnSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.End,
        )

        Text(
            modifier = Modifier
                .constrainAs(result) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(searchedNumber.bottom, margin = 16.dp)
                    bottom.linkTo(parent.bottom)

                    width = Dimension.fillToConstraints
                },
            text = fibonacciSearch.fibResult.joinToString(", "),
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Preview
@Composable
fun cardPreview() {
    FibonacciTheme {
        FibonacciCardComposable(
            fibonacciSearch = FibonacciSearch(
                fibonacciId = 0,
                searchedNumber = 34,
                fibResult = listOf(1, 2, 3, 4, 5),
                timeSearched = 1614926594000
            )
        )
    }
}
