package com.seniorjavasky.harry_potter_and_retrofit.lessons.compose.containers_2

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.lessons.compose.elements_1.ExploreButtonScreen
import com.seniorjavasky.harry_potter_and_retrofit.lessons.compose.elements_1.MyFloatingActionButton
import com.seniorjavasky.harry_potter_and_retrofit.lessons.compose.elements_1.TextScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyScaffold() {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { MyTopAppBar(scaffoldState, scope) },
        bottomBar = { MyBottomAppBar() },
        content = { ExploreButtonScreen() },
        drawerContent = { TextScreen() },
        floatingActionButton = { MyFloatingActionButton() }
    )
}

@Composable
fun MyTopAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    val drawerState = scaffoldState.drawerState
    TopAppBar(
        navigationIcon = {
            IconButton(
                content = {
                    Icon(
                        Icons.Default.Menu,
                        contentDescription = "menu",
//                        tint = Color.Green
                    )
                },
                onClick = {
                    scope.launch {
                        if (drawerState.isClosed)
                            drawerState.open()
                        else
                            drawerState.close()
                    }
                }
            )
        },
        title = { Text(stringResource(R.string.app_name)) },
    )
}

@Composable
fun MyBottomAppBar() {
    BottomAppBar(
        content={},
        backgroundColor = Color.Green
    )
}