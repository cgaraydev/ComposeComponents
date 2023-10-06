package com.example.composecomponents.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyRadioButton1() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = state,
            enabled = false,
            onClick = { state = !state },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Black,
                unselectedColor = Color.Red,
                disabledColor = Color.Green
            )
        )
        Text(
            text = "ejemplo1",
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.body1.merge()
        )
    }
}


@Composable
fun MyRadioButton2(name: String, onItemSelected: (String) -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "ejemplo1",
                onClick = { onItemSelected("ejemplo1") }
            )
            Text(
                text = "ejemplo1",
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.body1.merge()
            )
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "ejemplo2",
                onClick = { onItemSelected("ejemplo2") }
            )
            Text(
                text = "ejemplo2",
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.body1.merge()
            )
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "ejemplo3",
                onClick = { onItemSelected("ejemplo3") }
            )
            Text(
                text = "ejemplo3",
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.body1.merge()
            )
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "ejemplo4",
                onClick = { onItemSelected("ejemplo4") }
            )
            Text(
                text = "ejemplo4",
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.body1.merge()
            )
        }
    }
}

@Composable
fun RadioGroup(
    modifier: Modifier,
    items: List<String>,
    selection: String,
    onItemClick: ((String) -> Unit)
) {
    Column(modifier = modifier) {
        items.forEach { item ->
            LabelledRadioButton(
                modifier = Modifier.fillMaxWidth(),
                label = item,
                selected = item == selection,
                onClick = {
                    onItemClick(item)
                }
            )
        }
    }
}

@Composable
fun LabelledRadioButton(
    modifier: Modifier = Modifier,
    label: String,
    selected: Boolean,
    onClick: (() -> Unit)?,
    enabled: Boolean = true,
    colors: RadioButtonColors = RadioButtonDefaults.colors()
) {

    Row(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            enabled = enabled,
            colors = colors
        )

        Text(
            text = label,
            style = MaterialTheme.typography.body1.merge(),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun Example3() {
    val animalTypes = listOf("Todos", "Perro", "Gato", "Aves")
    val currentSelection = remember { mutableStateOf(animalTypes.first()) }

    RadioGroup(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        items = animalTypes,
        selection = currentSelection.value,
        onItemClick = { clickedItem ->
            currentSelection.value = clickedItem
        }
    )
}
