package com.example.demokotlin.page.bottombar.view

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable

@Composable
fun BottomScreen(pagerState: PagerState, pageContent: @Composable PagerScope.(page: Int) -> Unit) {
    HorizontalPager(
        state = pagerState,
        pageContent = pageContent,
    )
}