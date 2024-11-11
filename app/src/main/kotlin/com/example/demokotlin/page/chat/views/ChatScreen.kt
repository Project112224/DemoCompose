package com.example.demokotlin.page.chat.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.demokotlin.util.bottomBarHeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen() {
    // int list
    val tableData = (1..4).toList()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Chats")
                },
                modifier = Modifier
                    .drawBehind {
                        val borderSize = 1.dp.toPx()
                        val y = size.height - borderSize / 2
                        drawLine(
                            color = Color.Gray.copy(alpha = 0.5f),
                            start = Offset(0f, y),
                            end = Offset(size.width, y),
                            strokeWidth = borderSize
                        )
                    }
                    .padding(1.dp)
                    .background(Color.White)
            )
        },

        ) { padding ->
        LazyColumn(
            Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .background(Color.White)
                .padding(0.dp, 80.dp, 0.dp, bottomBarHeight.dp)
        ) {
            items(tableData) { index ->
                ChatItem(index)
            }
        }
    }
}