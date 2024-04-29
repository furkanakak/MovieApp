package com.furkan.core.common.extension

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * Extends RecyclerView to trigger events when scrolling reaches the end of the list.
 * @param scope CoroutineScope where the coroutines are launched, managing lifecycle of the asynchronous tasks.
 * @param isLoadingFlow MutableStateFlow<Boolean> indicating the loading state. It's set to true when loading starts and should be set to false when loading completes.
 * @param onEndReached A lambda function to be invoked when the end of the list is reached. Typically used to load more data.
 * The ScrollListener is activated each time the RecyclerView is scrolled. When the end of the list is detected, and if not already loading (checked via isLoadingFlow),
 * the isLoadingFlow is set to true, and onEndReached is called to initiate data loading. The coroutine collects changes on isLoadingFlow, adding or removing the ScrollListener based
 * on whether loading is ongoing, thus preventing multiple loading triggers during a single load.
 */
fun RecyclerView.onScrollToEnd(
    scope: CoroutineScope,
    isLoadingFlow: MutableStateFlow<Boolean>,
    onEndReached: () -> Unit
) {
    val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val totalItemCount = layoutManager.itemCount
            val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
            if (totalItemCount > 0 && lastVisibleItemPosition == totalItemCount - 1) {
                isLoadingFlow.value = true
                onEndReached()
            }
        }
    }

    scope.launch {
        isLoadingFlow.collect { isLoading ->
            if (!isLoading) {
                this@onScrollToEnd.addOnScrollListener(scrollListener)
            } else {
                this@onScrollToEnd.removeOnScrollListener(scrollListener)
            }
        }
    }
}
