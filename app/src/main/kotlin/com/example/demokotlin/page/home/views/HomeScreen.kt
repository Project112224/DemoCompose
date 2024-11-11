package com.example.demokotlin.page.home.views

//import androidx.compose.ui.platform.LocalConfiguration
//import androidx.compose.ui.platform.LocalConfiguration
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.demokotlin.common.ui.AppButton
import com.example.demokotlin.common.ui.AppDialog
import com.example.demokotlin.common.ui.OtherButton
import com.example.demokotlin.common.ui.TitleText
import com.example.demokotlin.page.home.viewModel.HomeViewModel
import com.example.demokotlin.util.bottomBarHeight

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel) {
    // API
    val categories by remember { viewModel.categories }

    // UI
//    val configuration = LocalConfiguration.current
//    val screenHeight = configuration.screenHeightDp.dp
//    val screenWidth = configuration.screenWidthDp

    val pagerState = rememberPagerState(pageCount = { categories.categories.size })
    val state = rememberLazyStaggeredGridState()
    val showExitDialog = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.fetchCategories()
    }

    // 顯示提示視窗
    if (showExitDialog.value) {
        AppDialog(
            title = "提醒",
            content = {
                Text("您即將返回登入頁，需重新登入!")
            },
            onDismiss = { showExitDialog.value = false },
            confirmButton = {
                AppButton(
                    title = "確認",
                    modifier = Modifier.fillMaxWidth(),
                    verticalSpace = 8.dp,
                    onClick = {
                        showExitDialog.value = false
                        navController.popBackStack()
                    }
                )
            },
            dismissButton = {
                OtherButton(
                    title = "取消",
                    modifier = Modifier.fillMaxWidth(),
                    verticalSpace = 8.dp,
                    onClick = {
                        showExitDialog.value = false
                    }
                )
            }
        )
    }

    BackHandler(true) {
        showExitDialog.value = true
    }

    LazyVerticalStaggeredGrid(
        modifier = Modifier
            .statusBarsPadding()
            .background(Color.White)
            .padding(0.dp, 32.dp, 0.dp, (16 + bottomBarHeight).dp),
        columns = StaggeredGridCells.Fixed(2),
        state = state,
        content = {
            item(span = StaggeredGridItemSpan.FullLine) {
                Header()
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                Column(modifier = Modifier.height(387.dp)) {
                    if (categories.categories.isEmpty()) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "Loading...".uppercase(),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.W900,
                                textAlign = TextAlign.Center,
                            )
                        }
                    } else {
                        HorizontalPager(
                            state = pagerState,
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            pageSpacing = 16.dp,
                            pageContent = { page ->
                                SheepCard(
                                    sheepInfo = categories.categories[page],
                                    navController
                                )
                            }
                        )
                    }
                }
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                Column(
                    modifier = Modifier.padding(16.dp, 0.dp)
                ) {
                    Spacer(modifier = Modifier.height(48.dp))
                    Text(
                        text = "Browse all".uppercase(),
                        fontWeight = FontWeight.W900,
                        fontSize = 13.sp,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.height(17.5.dp))
                }
            }
            items(categories.categories) { category ->
                Box(
                    modifier = Modifier
                        .padding(4.5.dp)
                        .width(167.dp)
                        .height((100..200).random().dp)
                ) {
                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = category.strCategoryThumb,
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                    )
                }
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                Footer(navController)
            }
        }
    )
}

@Composable
fun Header() {
    Column(
        modifier = Modifier.padding(16.dp, 0.dp)
    ) {
        TitleText("Discover")
        Spacer(modifier = Modifier.height(32.dp))
        Text("What’s new today".uppercase(), fontSize = 13.sp, fontWeight = FontWeight.Black)
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun Footer(navController: NavHostController) {
    Column(
        modifier = Modifier.padding(16.dp, 0.dp)
    ) {
        Spacer(modifier = Modifier.height(25.5.dp))
        OtherButton(
            title = "See More",
            modifier = Modifier.fillMaxWidth(),
            verticalSpace = 8.dp,
            onClick = { Log.d("HomeScreen", "See More") }
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}