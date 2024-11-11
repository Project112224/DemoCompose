package com.example.demokotlin.page.home.views

//import coil3.compose.rememberAsyncImagePainter
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.error
import coil3.size.Size
import com.example.demokotlin.R
import com.example.demokotlin.model.api.datas.Category
import com.example.demokotlin.page.main.PageName
import com.google.gson.Gson
import java.net.URLEncoder

@Composable
fun SheepCard(sheepInfo: Category, navController: NavController) {

    val backImage = painterResource(R.drawable.back)
    val imageUrl = sheepInfo.strCategoryThumb
//    val thumbImage = rememberAsyncImagePainter(
//        model = ImageRequest.Builder(LocalContext.current)
//            .data(imageUrl)
//            .size(Size.ORIGINAL)
//            .listener(
//                onStart = { request -> Log.d("SheepCard", "Image request started: $request") },
//                onSuccess = { request, metadata ->
//                    Log.d("SheepCard", "Image request successful: $request")
//                },
//                onError = { request, throwable ->
//                    Log.e("SheepCard", "Image request failed: $request")
//                }
//            )
//            .build()
//    )

    var categoryString: String? = null
    try {
        val gson = Gson()
        categoryString = gson.toJson(sheepInfo)
    } catch (ex: Exception) {
        Log.d("SheepCard", "Error: ${ex.message}")
    }

    Box(
        modifier = Modifier
            .clickable(
                onClick = {
                    categoryString?.let {
                        navController.navigate(
                            "${PageName.SheepDetail.route}/${URLEncoder.encode(it, "utf-8")}"
                        )
                    }
                }
            ),
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .size(Size.ORIGINAL)
                    .error(R.drawable.home)
                    .listener(
                        onStart = { request ->
                            Log.d(
                                "SheepCard",
                                "Image request started: $request"
                            )
                        },
                        onSuccess = { request, _ ->
                            Log.d("SheepCard", "Image request successful: $request")
                        },
                        onError = { request, _ ->
                            Log.e("SheepCard", "Image request failed: $request")
                        }
                    )
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            )

//        Image(
//            painter = thumbImage,
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .fillMaxSize()
//                .weight(1f)
//        )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Image(
                    painter = backImage,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = sheepInfo.idCategory,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.Black,
                    )
                    Text(
                        text = "@${sheepInfo.strCategory}",
                        fontWeight = FontWeight.W400,
                        fontSize = 11.sp,
                        color = Color.Black,
                    )
                }
            }
        }
    }
}