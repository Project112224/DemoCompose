package com.example.demokotlin.page.bottombar.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun AppNavigationBar(pagerState: PagerState, items: List<BottomBarScreenView>) {

    val scope = rememberCoroutineScope()
    NavigationBar(
        modifier = Modifier
            .height(83.dp)
            .background(Color.White)
            .drawBehind {
                val strokeWidthPx = density.run { 2.dp.toPx() }
                drawLine(
                    color = Color.LightGray,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = strokeWidthPx
                )
            },
        contentColor = Color.White,
        containerColor = Color.White
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() } // This is mandatory
                    ) {},
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White
                ),
                interactionSource = remember { MutableInteractionSource() },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.scrollToPage(page = index)
                    }
                },
                icon = { if (2 == index) CenterItem(item) else DefaultItem(item) },
//                label = { Text(text = item.title) }
            )
        }
    }
}