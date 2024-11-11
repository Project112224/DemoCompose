package com.example.demokotlin.page.chat.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demokotlin.R

@Composable
fun ChatItem(index: Int) {
    Column {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(64.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray.copy(alpha = 0.5f), CircleShape)
            )
            Box(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    "User $index",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.W700,
                )
                Box(modifier = Modifier.height(6.dp))
                Text(
                    "Message $index",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.W400,
                    modifier = Modifier.weight(1f)
                )
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.3f))
                .height(0.5.dp)
        )
    }
}