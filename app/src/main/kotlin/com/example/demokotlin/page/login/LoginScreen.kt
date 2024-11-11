package com.example.demokotlin.page.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.demokotlin.R
import com.example.demokotlin.common.ui.AppButton
import com.example.demokotlin.common.ui.AppTextField
import com.example.demokotlin.common.ui.TitleText
import com.example.demokotlin.page.main.PageName

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController, title: String) {
    val isLogin: Boolean = title == "Login"
    val backImage = painterResource(R.drawable.back)
    val focusManager = LocalFocusManager.current
    val mailText = remember { mutableStateOf(TextFieldValue("")) }
    val pwText = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {
        TopAppBar(
            navigationIcon = {
                IconButton(
                    onClick = { navController.popBackStack() },
                ) {
                    Image(
                        painter = backImage,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(15.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
                titleContentColor = Color.White
            ),
            title = {}
        )
        Column(modifier = Modifier.padding(16.dp, 0.dp)) {
            Spacer(modifier = Modifier.height(32.dp))
            TitleText(title)
            Spacer(modifier = Modifier.height(32.dp))
            AppTextField(
                placeholder = "Email",
                text = mailText,
                onTextChange = { mailText.value = TextFieldValue(it) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            AppTextField(
                placeholder = "Password",
                text = pwText,
                onTextChange = { pwText.value = TextFieldValue(it) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            AppButton(
                title = if (isLogin) "Login" else "Next",
                Modifier.fillMaxWidth(),
                verticalSpace = 10.dp,
                onClick = {
                    // TODO: Register to phone auth page
                    navController.navigate(PageName.BottomBar.route)
                }
            )
        }
    }
}
