package com.example.composecomponents.mylayers

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyRow1() {
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
//        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text(text = "ejemplo1")
        Text(text = "ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "ejemplo1")
        Text(text = "ejemplo1")
        Text(text = "ejemplo1")
        Text(text = "ejemplo1")
        Text(text = "ejemplo1")
    }
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "ejemplo1")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Green)
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "ejemplo1", color = Color.Black)

            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Black)
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "ejemplo1", color = Color.White)

            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .weight(1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "ejemplo1", color = Color.White)

        }
    }
}
