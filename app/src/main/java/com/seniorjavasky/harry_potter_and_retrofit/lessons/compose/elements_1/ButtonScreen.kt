package com.seniorjavasky.harry_potter_and_retrofit.lessons.compose.elements_1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.seniorjavasky.harry_potter_and_retrofit.R

@Composable
fun ExploreButtonScreen() {

    Card(
        backgroundColor = Color.Cyan,
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable { },
        elevation = 16.dp,

        ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            MyButton()
            MyOutlinedButton()
            MyTextButton()
            MyRadioGroup()
            MyFloatingActionButton()
            MyIconButton()
            MyIconToggleButton()
            MyyCheckbox()
            MySwitch()
        }
    }
}

@Composable
fun MySwitch() {
    val checked = remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Switch(
            checked = checked.value,
            onCheckedChange = { checked.value = it },
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
        )
        Text("Label")
    }

}


@Composable
fun MyyCheckbox() {
    val checked = remember { mutableStateOf(false) }


    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked.value = it },
            modifier = Modifier.padding(start = 8.dp)
        )
        Text("Label")
    }

}


@Composable
fun MyButton() {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(R.color.teal_700),
            contentColor = colorResource(R.color.teal_700)
        ),
        border = BorderStroke(1.dp, colorResource(R.color.purple_700)),
        elevation = ButtonDefaults.elevation(defaultElevation = 16.dp),
        enabled = true
    ) {
        Text(
            text = stringResource(R.string.sign_in),
            color = Color.White
        )
    }
}

@Composable
fun MyOutlinedButton() {
    OutlinedButton(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = colorResource(R.color.teal_700)
        )
    ) {
        Text(
            text = stringResource(R.string.sign_in),

            )
    }
}

@Composable
fun MyTextButton() {
    TextButton(
        onClick = { },
        content = { Text(text = "TextButton") }
    )
}

@Composable
fun MyRadioGroup() {
    val radioButtons = listOf(0, 1, 2)

    val selectedButon = remember {
        mutableStateOf(radioButtons.first())
    }
    Column {
        radioButtons.forEach { index ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = index == selectedButon.value,
                    onClick = { selectedButon.value = index },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Red
                    )
                )
                Text(text = "Label $index")
            }
        }
    }
}

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = { },
        backgroundColor = colorResource(R.color.teal_700),
        contentColor = Color.Red,
        content = { Icon(Icons.Filled.Add, "icon") }
    )
}

@Composable
fun MyIconButton() {
    IconButton(onClick = { },
        content = { Icon(Icons.Filled.Call, contentDescription = "") }
    )
//    {
//        Icon(Icons.Filled.Call, contentDescription = "")
//    }
}

@Composable
fun MyIconToggleButton() {

    val checked = remember { mutableStateOf(false) }


    IconToggleButton(
        checked = checked.value,
        onCheckedChange = { checked.value = it },
        content = {
            Icon(
                Icons.Filled.Info,
                contentDescription = "info",
                tint = if (checked.value) Color.Green else Color.Yellow
            )
        }
    )
}





