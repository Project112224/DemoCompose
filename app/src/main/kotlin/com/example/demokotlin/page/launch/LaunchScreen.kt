package com.example.demokotlin.page.launch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.demokotlin.R
import com.example.demokotlin.common.ui.AppButton
import com.example.demokotlin.common.ui.OtherButton
import com.example.demokotlin.page.main.PageName

@Composable
fun LaunchScreen(navController: NavHostController) {
    val launchImage = painterResource(R.drawable.launch)
    val logoImage = painterResource(R.drawable.logo)
    val screenWidth = LocalConfiguration.current.screenWidthDp.toFloat()
    val paddingSpace = 5.dp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                Image(
                    painter = launchImage,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = logoImage,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .width(206.dp)
                        .height(54.dp)
                )
                Image(
                    painter = logoImage,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .width(206.dp)
                        .height(54.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                OtherButton(
                    title = "Log in",
                    modifier = Modifier.width((screenWidth * 0.445).dp),
                    verticalSpace = paddingSpace,
                    onClick = {
                        navController.navigate("${PageName.Login.route}/Login")
                    }
                )
                Spacer(modifier = Modifier.width(9.dp))
                AppButton(
                    title = "Register",
                    modifier = Modifier.width((screenWidth * 0.445).dp),
                    verticalSpace = paddingSpace,
                    onClick = {
                        navController.navigate("${PageName.Login.route}/Register")
                    }
                )
            }
        }
    }
}
