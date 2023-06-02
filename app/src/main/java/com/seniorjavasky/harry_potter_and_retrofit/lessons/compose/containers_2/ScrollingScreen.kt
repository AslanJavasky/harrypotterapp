//package com.seniorjavasky.harry_potter_and_retrofit.lessons.compose.containers_2
//
//import androidx.annotation.DrawableRes
//import androidx.annotation.StringRes
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.horizontalScroll
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.ImageBitmap
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.imageResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.unit.dp
//import com.seniorjavasky.harry_potter_and_retrofit.R
//
//@Composable
//fun ScrollingScreen() {
//
//    MyRowScrollingScreen()
//
//
//}
//
//@Composable
//fun MyColumnScrollingScreen() {
//    Column(
//        modifier = Modifier.verticalScroll(
//            rememberScrollState(),
//            enabled = true,
//            reverseScrolling = false
//        )
//    ) {
//        BookImage(R.drawable.advanced_architecture_android, R.string.advanced_architecture_android)
//        BookImage(R.drawable.android_aprentice, R.string.kotlin_apprentice)
//        BookImage(R.drawable.kotlin_coroutines, R.string.kotlin_coroutines)
//    }
//}
//
//@Composable
//fun MyRowScrollingScreen() {
//    Row(
//        modifier = Modifier.horizontalScroll(
//            rememberScrollState(),
//            enabled = true,
//            reverseScrolling = false
//        )
//    ) {
//        BookImage(R.drawable.advanced_architecture_android, R.string.advanced_architecture_android)
//        BookImage(R.drawable.android_aprentice, R.string.kotlin_apprentice)
//        BookImage(R.drawable.kotlin_coroutines, R.string.kotlin_coroutines)
//    }
//}
//
//@Composable
//fun BookImage(
//    @DrawableRes imageResId: Int,
//    @StringRes contentDescriptionResId: Int
//) {
//    Image(
//        ImageBitmap.imageResource(imageResId),
//        contentDescription = stringResource(contentDescriptionResId),
//        contentScale = ContentScale.FillBounds,
//        modifier = Modifier.size(476.dp, 616.dp)
//    )
//
//
//}
//
