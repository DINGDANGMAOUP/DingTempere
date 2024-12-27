package com.dingdangmaoup

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.MaterialTheme
@Composable
fun MyLayout() {
    var falg by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar (
            ){
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favorite",
                        tint = Color.Red
                    )

                }
            }
        },
        bottomBar = {
            BottomAppBar(cutoutShape = MaterialTheme.shapes.small.copy(
                CornerSize(percent = 50)
            )) {

            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    falg=true
                }
            ){
                Icon(
//                    modifier=Modifier.size(24.dp),
                    imageVector = Icons.Filled.Add,
                    contentDescription = "add",
                )
            }
        },
        isFloatingActionButtonDocked = true
    ) {
        // Screen content
        Button(
            onClick = {
                falg = true

            },
        ) {
            Text("Hello, World!")
        }
    }

}