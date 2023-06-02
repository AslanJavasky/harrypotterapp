//package com.seniorjavasky.harry_potter_and_retrofit.lessons.compose.containers_2
//
//import androidx.annotation.StringRes
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.seniorjavasky.harry_potter_and_retrofit.R
//import androidx.compose.foundation.lazy.items
//
//
//@Composable
//fun ListScreen() {
//    MyList()
//}
//
//@Composable
//fun MyList() {
//    LazyColumn {
//        items(items) {
//            ListItem(it)
//        }
//        item { Text(text = "HELLO WORLD!") }
//    }
//}
//
//
//@Composable
//fun ListItem(
//    bookCategory: BookCategory,
//    modifier: Modifier = Modifier
//) {
//    Column(
//        modifier = Modifier.padding(8.dp)
//    ) {
//        Text(
//            text = stringResource(bookCategory.categoryResourceId),
//            fontSize = 22.sp,
//            fontWeight = FontWeight.Bold,
//            color = colorResource(id = R.color.purple_700)
//        )
//
//        Spacer(modifier = modifier.height(8.dp))
//
//        LazyRow {
//            items(bookCategory.bookImageResources) {
//                BookImage(it)
//            }
//        }
//    }
//}
//
//@Composable
//fun BookImage(imageResource: Int) {
//    Image(
//        modifier = Modifier.size(170.dp, 200.dp),
//        painter = painterResource(id = imageResource),
//        contentScale = ContentScale.Fit,
//        contentDescription =null
//    )
//}
//
//data class BookCategory(
//    @StringRes val categoryResourceId: Int,
//    val bookImageResources: List<Int>
//)
//
//private val items = listOf(
//    BookCategory(
//        R.string.android,
//        listOf(
//            R.drawable.android_aprentice,
//            R.drawable.saving_data_android,
//            R.drawable.advanced_architecture_android
//        )
//    ),
//    BookCategory(
//        R.string.kotlin,
//        listOf(
//            R.drawable.kotlin_coroutines,
//            R.drawable.kotlin_aprentice
//        )
//    ),
//    BookCategory(
//        R.string.swift,
//        listOf(
//            R.drawable.combine,
//            R.drawable.rx_swift,
//            R.drawable.swift_apprentice,
//        )
//    ),
//    BookCategory(
//        R.string.ios,
//        listOf(
//            R.drawable.core_data,
//            R.drawable.ios_apprentice,
//        )
//    )
//)
//
//
