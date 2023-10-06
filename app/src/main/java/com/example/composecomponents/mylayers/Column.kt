package com.example.composecomponents.mylayers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyColumn() {
    Column(Modifier.fillMaxSize()) {
        Text(
            text = "ejemplo1", modifier = Modifier
                .background(Color.Red)
                .weight(1f)
        )
        Text(
            text = "ejemplo1", modifier = Modifier
                .background(Color.Green)
                .weight(1f)
        )
        Text(
            text = "ejemplo1", modifier = Modifier
                .background(Color.Yellow)
                .weight(1f)
        )
        Text(
            text = "ejemplo1", modifier = Modifier
                .background(Color.Blue)
                .weight(1f)
        )
    }
}

@Composable
fun MyColumn2() {
    Column(
        Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.SpaceBetween
//        verticalArrangement = Arrangement.SpaceAround
        verticalArrangement = Arrangement.SpaceEvenly,
//        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = "ejemplo1",
            modifier = Modifier
                .background(Color.Red)
        )
        Text(
            text = "ejemplo1", modifier = Modifier
                .background(Color.Green)
        )
        Text(
            text = "ejemplo1", modifier = Modifier
                .background(Color.Yellow)
        )
        Text(
            text = "ejemplo1", modifier = Modifier
                .background(Color.Blue)
                .align(Alignment.End)
        )
    }
}


@Composable
fun MyColumn3() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "ejemplo1",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "ejemplo1",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "ejemplo1",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "ejemplo1",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "ejemplo1",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "ejemplo1",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "ejemplo1",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "ejemplo1",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}


@Composable
fun MyColumn4() {
    Column {
        // The child with no weight will have the specified size.
        Box(
            Modifier
                .size(40.dp, 80.dp)
                .background(Color.Magenta)
        )
        // Has weight, the child will occupy half of the remaining height.
        Box(
            Modifier
                .width(40.dp)
                .weight(1f)
                .background(Color.Yellow)
        )
        // Has weight and does not fill, the child will occupy at most half of the remaining height.
        // Therefore it will occupy 80.dp (its preferred height) if the assigned height is larger.
        Box(
            Modifier
                .size(40.dp, 80.dp)
                .weight(1f, fill = false)
                .background(Color.Green)
        )
    }
}
