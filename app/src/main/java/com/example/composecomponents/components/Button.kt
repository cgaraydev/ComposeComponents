package com.example.composecomponents.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import java.time.LocalDateTime
import kotlin.random.Random


@Composable
fun MyButton1() {
    var enabled by remember { mutableStateOf(true) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Green
            ),
            border = BorderStroke(5.dp, Color.Gray),
            modifier = Modifier.size(300.dp, 100.dp)
        ) {
            Text(text = "Press Me")
        }
    }
}

@Composable
fun MyButton2() {
    OutlinedButton(
        onClick = { },
//        enabled = false,
        modifier = Modifier
            .size(300.dp, 100.dp)
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Magenta,
            contentColor = Color.Green,
            disabledContentColor = Color.Gray,
            disabledBackgroundColor = Color.White
        )
    ) {
        Text(text = "No me presiones")
    }
}

@Composable
fun MyButton3(){
    TextButton(onClick = { }, modifier = Modifier.padding(16.dp)) {
        Text(text = "clickeame")
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OutlinedButtonExample() {
    var date by remember { mutableStateOf(LocalDateTime.now()) }

    Column {

        OutlinedButton(
            onClick = { date = LocalDateTime.now() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("INFORMAR")
        }
        Spacer(Modifier.size(16.dp))
        Text(
            "Fecha actual -> $date",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ContainedButtonExample() {
    val WIDTH1 = 150.dp
    val WIDTH2 = 200.dp
    val WIDTH3 = 300.dp

    var width by remember { mutableStateOf(WIDTH1) }

    Button(
        onClick = {
            width = when (width) {
                WIDTH1 -> WIDTH2
                WIDTH2 -> WIDTH3
                else -> WIDTH1
            }
        },
        modifier = Modifier.width(width)
    ) {
        Text("CAMBIAR")
    }
}

@Composable
fun IconButtonExample() {
    var color by remember { mutableStateOf(Color.LightGray) }

    IconButton(
        onClick = {
            val randomColor = Color(Random.nextLong(0xFF000000, 0xFFFFFFFF))
            color = randomColor
        }) {
        Icon(
            Icons.Filled.Home,
            contentDescription = "Cambiar color",
            tint = color
        )
    }
}

@Composable
fun ButtonWithIconExample() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Botones Con Icono", style = MaterialTheme.typography.h6)
        Spacer(Modifier.size(8.dp))
        TextButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("BOTÓN")
        }
        Spacer(Modifier.size(8.dp))
        OutlinedButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("BOTÓN")
        }
        Spacer(Modifier.size(8.dp))
        Button(onClick = { }) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("BOTÓN")
        }
    }
}

//@Composable
//fun ToggleButtonExample() {
//    var checked by remember { mutableStateOf(false) } //1
//
//    IconToggleButton(checked = checked, onCheckedChange = { checked = it }) { //2
//        Icon(
//            painter = painterResource( //3
//                if (checked) R.drawable.ic_bookmark
//                else R.drawable.ic_bookmark_border
//            ),
//            contentDescription = //4
//            if (checked) "Añadir a marcadores"
//            else "Quitar de marcadores",
//            tint = Color(0xFF26C6DA) //5
//        )
//    }
//}

@Composable
fun ButtonToggleGroupExample() {
    val auto = "AUTO"
    val dark = "OSCURO"
    val light = "LIGHT"
    val options = listOf(auto, dark, light)

    var selectedOption by remember { mutableStateOf(options[0]) }

    ButtonToggleGroup(
        options = options,
        selectedOption = selectedOption,
        onOptionSelect = { selectedOption = it },
    )
}
@Composable
fun ButtonToggleGroup( // 1
    options: List<String>,
    selectedOption: String,
    onOptionSelect: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier) { // 2
        options.forEachIndexed { index, option -> // 3
            val selected = selectedOption == option // 4

            val border = if (selected) BorderStroke( // 5
                width = 1.dp,
                color = MaterialTheme.colors.primary
            ) else ButtonDefaults.outlinedBorder

            val shape = when (index) { // 6
                0 -> RoundedCornerShape(
                    topStart = 4.dp,
                    bottomStart = 4.dp,
                    topEnd = 0.dp,
                    bottomEnd = 0.dp
                )
                options.size - 1 -> RoundedCornerShape(
                    topStart = 0.dp, bottomStart = 0.dp,
                    topEnd = 4.dp,
                    bottomEnd = 4.dp
                )
                else -> CutCornerShape(0.dp)
            }

            val zIndex = if (selected) 1f else 0f

            val buttonModifier = when (index) { // 7
                0 -> Modifier.zIndex(zIndex)
                else -> {
                    val offset = -1 * index
                    Modifier
                        .offset(x = offset.dp)
                        .zIndex(zIndex)
                }
            }

            val colors = ButtonDefaults.outlinedButtonColors( // 8
                backgroundColor = if (selected) MaterialTheme.colors.primary.copy(alpha = 0.12f)
                else MaterialTheme.colors.surface,
                contentColor = if (selected) MaterialTheme.colors.primary else Color.DarkGray
            )
            OutlinedButton( // 9
                onClick = { onOptionSelect(option) },
                border = border,
                shape = shape,
                colors = colors,
                modifier = buttonModifier.weight(1f)
            ) {
                Text(option) // 10
            }
        }
    }
}