package com.mumbicodes.fibonacci.presentation.searchNumber

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mumbicodes.fibonacci.domain.model.FibonacciSearch
import com.mumbicodes.fibonacci.domain.repository.FibonacciRepository
import com.mumbicodes.fibonacci.presentation.util.toLong
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class SearchNumberViewModel @Inject constructor(
    private val repository: FibonacciRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<FibonacciUiState> =
        MutableStateFlow(FibonacciUiState.Loading)
    val state: StateFlow<FibonacciUiState> = _state.asStateFlow()

    private val _searchParamState = mutableStateOf("")
    val searchParamState = _searchParamState

    private var fibonacciJob: Job? = null

    init {
        updateState(FibonacciUiState.Loading)
        getPreviousSearches()
    }

    fun calculateArbitraryNumbers(searchParam: String) {
        updateState(FibonacciUiState.Loading)

        fibonacciJob?.cancel()
        fibonacciJob = viewModelScope.launch {

            updateSearchParameter(searchParam)

            val results = generateArbitraryNumbers(searchParam.toLong())

            val time = LocalDateTime.now()
            val fibonacciSearch = FibonacciSearch(
                fibonacciId = 0,
                searchedNumber = searchParam.toLong(),
                fibResult = results,
                timeSearched = time.toLong()
            )
            updateState(
                FibonacciUiState.SearchResult(
                    result = fibonacciSearch
                )
            )

            insertFibonacciNumber(fibonacciSearch)
        }
    }
    private fun generateArbitraryNumbers(searchParam: Long): List<Int> {
        val arbNums = mutableListOf(0, 1)
        val searchP = searchParam.toInt()
        if (searchP < 2) {
            return arbNums.take(searchP + 1)
        }
        var prev = 0
        var curr = 1
        for (i in 2..searchP) {
            val nextFib = prev + curr
            arbNums.add(nextFib)
            prev = curr
            curr = nextFib
        }
        return arbNums
    }

    fun getPreviousSearches() {
        fibonacciJob?.cancel()
        fibonacciJob = viewModelScope.launch {
            repository.getFibonacciNumbers().collectLatest {
                updateState(FibonacciUiState.Data(it))
            }
        }
    }

    private fun insertFibonacciNumber(fibonacciSearch: FibonacciSearch) {
        viewModelScope.launch {
            repository.insertFibonacciNumber(fibonacciSearch)
        }
    }

    fun deleteFibonacciNumber(fibonacciId: Int) {
        viewModelScope.launch {
            repository.deleteFibonacciNumber(fibonacciId)
        }
    }

    fun deleteAllFibonacciNumbers() {
        viewModelScope.launch {
            repository.deleteAllFibonacciNumbers()
        }
    }

    private fun updateState(state: FibonacciUiState) {
        _state.value = state
    }

    fun updateSearchParameter(searchParam: String) {
        if (searchParam.isEmpty()) {
            getPreviousSearches()
        }
        _searchParamState.value = searchParam
    }
}

sealed class FibonacciUiState {
    object Loading : FibonacciUiState()
    data class Data(val data: List<FibonacciSearch>) : FibonacciUiState()
    data class SearchResult(val result: FibonacciSearch) : FibonacciUiState()
}
