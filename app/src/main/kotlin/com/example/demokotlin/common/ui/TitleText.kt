package com.example.demokotlin.common.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.demokotlin.R

val Comfortaa = FontFamily(Font(R.font.comfortaa, FontWeight.Normal))
@Composable
fun TitleText(text: String) {
    Text(
        text,
        color = Color.Black,
        fontSize = 36.sp,
        fontWeight = FontWeight.W400,
        fontFamily = Comfortaa,
    )
}