package com.example.demokotlin.page.bottombar.view

import androidx.compose.ui.graphics.Color
import com.example.demokotlin.R
import com.example.demokotlin.page.main.PageName

sealed class BottomBarScreenView(
    val route: String,
    val title: String,
    val color: Color,
    val iconInt: Int
) {
    object Home : BottomBarScreenView(
        route = PageName.Home.route,
        title = "首頁",
        color = Color.Green,
        iconInt = R.drawable.home
    )
    object Search : BottomBarScreenView(
        route = PageName.Search.route,
        title = "搜尋",
        color = Color.Red,
        iconInt = R.drawable.search
    )
    object News : BottomBarScreenView(
        route = PageName.News.route,
        title = "最新消息",
        color = Color.Green,
        iconInt = R.drawable.tab_add
    )
    object Message : BottomBarScreenView(
        route = PageName.Message.route,
        title = "訊息",
        color = Color.Blue,
        iconInt = R.drawable.message
    )
    object Person : BottomBarScreenView(
        route = PageName.Person.route,
        title = "設定",
        color = Color.Gray,
        iconInt = R.drawable.person
    )
}