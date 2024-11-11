package com.example.demokotlin.page.bottombar.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.demokotlin.util.bottomBarHeight

@Composable
fun DefaultItem(item: BottomBarScreenView) {
    Image(
        painter = painterResource(item.iconInt),
        contentDescription = null,
        modifier = Modifier.size(20.dp)
    )
}

@Composable
fun CenterItem(item: BottomBarScreenView) {
    Box(
        modifier = Modifier
            .height(bottomBarHeight.dp)
            .fillMaxWidth()
            .padding(0.dp, 5.dp)
            .clip(shape = RoundedCornerShape(30.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFF00D6),
                        Color(0xFFFF4D00),
                    )
                )
            )
    ) {
        Image(
            painter = painterResource(item.iconInt),
            contentDescription = null,
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .width(20.dp)
                .height(20.dp)
        )
    }
}