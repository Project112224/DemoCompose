package com.example.demokotlin.common.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun AppTextField(
    placeholder: String,
    text: MutableState<TextFieldValue>,
    onTextChange: (String) -> Unit
) {
    OutlinedTextField(
        text.value.text,
        placeholder = { Text(placeholder) },
        onValueChange = onTextChange,
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .border(
                BorderStroke(width = 2.dp, color = Color.Black),
    //                    shape = RoundedCornerShape(6.dp)
            ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
    )
}