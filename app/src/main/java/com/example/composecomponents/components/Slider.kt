package com.example.composecomponents.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun MySlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0f) }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun MyAdvancedSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0f) }
        var completeValue by remember { mutableStateOf("") }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = { completeValue = sliderPosition.toString() },
            valueRange = 0f..10f,
            steps = 9,
            enabled = true
        )
        Text(text = completeValue)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var currentRange by remember { mutableStateOf(0f..10f) }
        RangeSlider(
            values = currentRange,
            onValueChange = { currentRange = it },
            valueRange = 0f..50f
        )

        Text(text = "Valor inferior :${currentRange.start}")
        Text(text = "Valor inferior :${currentRange.endInclusive}")

    }
}

@Composable
fun ContinuousSliderWithValue() {
    val range = 25f..50f
    var fontSize by remember { mutableStateOf(30f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.height(100.dp)
        ) {

            Text(text = "Develou", fontSize = fontSize.sp)
        }

        Spacer(Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {

            Slider(
                value = fontSize,
                valueRange = range,
                onValueChange = { fontSize = it },
                modifier = Modifier
                    .weight(0.9f)
                    .padding(end = 16.dp)
            )
            Text(
                text = fontSize.toInt().toString(),
                modifier = Modifier.weight(0.1f)
            )
        }
    }
}

@Composable
fun DiscreteSliderWithTextField() {
    val range = 0f..100f
    val steps = 4
    var sliderSelection by remember { mutableStateOf(range.start) }
    var selectionNumber by remember { mutableStateOf(range.start.toInt().toString()) }

    Row {

        Slider(
            value = sliderSelection,
            valueRange = range,
            steps = steps,
            onValueChange = { sliderSelection = it },
            onValueChangeFinished = {
                selectionNumber = sliderSelection.toInt().toString()
            },
            modifier = Modifier.width(250.dp)
        )

        Spacer(Modifier.width(16.dp))

        TextField(
            value = selectionNumber,
            onValueChange = {
                val segment = calculateSegment(it, range, steps)
                sliderSelection = segment
                selectionNumber = it
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.width(56.dp),
            colors = TextFieldDefaults.textFieldColors(unfocusedIndicatorColor = Color.Transparent)
        )
    }
}

fun calculateSegment(input: String, range: ClosedFloatingPointRange<Float>, steps: Int): Float {
    if (input.isBlank()) return 0.0F

    val selection = input.toFloat()

    if (selection > range.endInclusive) return range.endInclusive

    val segments = steps + 1
    val subRangeSize = (range.endInclusive - range.start) / segments

    val fraction: Float = range.endInclusive / selection
    val location = (segments / fraction).roundToInt()

    return location * subRangeSize
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColoredSlider() {
    val range = 1.0f..1000.0f
    val steps = 4
    var price by remember { mutableStateOf(1f..200f) }

    val green500 = Color(0xFF4CAF50)
    val green900 = Color(0xFF1B5E20)
    val lime500 = Color(0xFFCDDC39)

    RangeSlider(
        values = price,
        valueRange = range,
        steps = steps,
        onValueChange = { price = it },
        colors = SliderDefaults.colors(
            thumbColor = green900,
            activeTrackColor = green500,
            inactiveTrackColor = Color.LightGray.copy(alpha = 0.24f),
            activeTickColor = lime500,
            inactiveTickColor = lime500.copy(alpha = 0.56f)
        )
    )
}