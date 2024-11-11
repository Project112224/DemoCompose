package com.example.demokotlin.page.sheepDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.demokotlin.common.ui.OtherButton
import com.example.demokotlin.model.api.datas.Category

@Composable
fun SheepDetailScreen(navController: NavController, info: Category?) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        AsyncImage(
            model = info?.strCategoryThumb,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            info?.strCategoryDescription ?: "",
            modifier = Modifier
                .padding(16.dp)
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
                .height(16.dp)
        )
        OtherButton(
            title = "Back",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalSpace = 5.dp,
            onClick = { navController.popBackStack() }
        )
    }
}