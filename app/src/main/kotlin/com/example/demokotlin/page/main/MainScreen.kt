package com.example.demokotlin.page.main

import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demokotlin.model.api.datas.Category
import com.example.demokotlin.page.bottombar.view.AppNavigationBar
import com.example.demokotlin.page.bottombar.view.BottomBarScreenView
import com.example.demokotlin.page.bottombar.view.BottomScreen
import com.example.demokotlin.page.chat.views.ChatScreen
import com.example.demokotlin.page.home.views.HomeScreen
import com.example.demokotlin.page.home.viewModel.HomeViewModel
import com.example.demokotlin.page.launch.LaunchScreen
import com.example.demokotlin.page.login.LoginScreen
import com.example.demokotlin.page.page.PageScreen
import com.example.demokotlin.page.sheepDetail.SheepDetailScreen
import com.google.gson.Gson
import java.net.URLDecoder

@Composable
fun MainScreen(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "launch") {
        composable(PageName.Launch.route) { LaunchScreen(navController) }
        composable("${PageName.Login.route}/{title}") { entry ->
            val title: String = entry.arguments?.getString("title") ?: ""
            LoginScreen(navController, title = title)
        }
        composable(
            "${PageName.SheepDetail.route}/{info}",
            arguments = listOf(navArgument("info") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("info")?.let { encode ->
                val jsonString = URLDecoder.decode(encode, "utf-8")
                val gson = Gson()
                val info = gson.fromJson(jsonString, Category::class.java)
                SheepDetailScreen(navController, info)
            }
        }
        composable(PageName.BottomBar.route) {
            val items = listOf(
                BottomBarScreenView.Home,
                BottomBarScreenView.Search,
                BottomBarScreenView.News,
                BottomBarScreenView.Message,
                BottomBarScreenView.Person
            )

            val pagerState = rememberPagerState(pageCount = { items.size })
            Scaffold(
                bottomBar = { AppNavigationBar(pagerState, items) },
                content = {
                    BottomScreen(
                        pagerState = pagerState
                    ) { index ->
                        when (index) {
                            0 -> {
                                val viewModel = HomeViewModel()
                                HomeScreen(
                                    navController = navController,
                                    viewModel = viewModel
                                )
                            }

                            1 -> PageScreen(
                                BottomBarScreenView.Search.title,
                                BottomBarScreenView.Search.color,
                            )

                            2 -> PageScreen(
                                BottomBarScreenView.News.title,
                                BottomBarScreenView.News.color,
                            )

                            3 -> ChatScreen()

                            4 -> PageScreen(
                                BottomBarScreenView.Person.title,
                                BottomBarScreenView.Person.color,
                            )
                        }
                    }
                }
            )
        }
    }
}