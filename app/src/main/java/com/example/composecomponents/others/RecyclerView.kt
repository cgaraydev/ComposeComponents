package com.example.composecomponents.others

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecomponents.model.SuperHero
import kotlinx.coroutines.launch

@Composable
fun MyLazyColumn() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(100) { index ->
            Text("Item $index")
        }
    }
}

@Composable
fun SimpleRecyclerView() {
    val nombres =
        listOf("Ana", "Juan", "María", "Pedro", "Luis", "Lucía", "Marta", "Jorge", "Carla", "Diego")
    LazyColumn {
        items(nombres) {
            Text(text = "hola me llamo $it")
        }
    }
}

//@Composable
//fun SuperHeroView() {
//    val context = LocalContext.current
//    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//        items(getSuperHeroes()) { superHero ->
//            ItemHero(superHero = superHero, onItemSelected = {
//                Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
//            })
//        }
//    }
//}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemSelected(superHero)
            }
    ) {
        Column() {
            Image(
                painter = painterResource(id = superHero.drawable),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.name,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.pusblisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
                fontSize = 10.sp
            )
        }
    }
}

//fun getSuperHeroes(): List<SuperHero> {
//    return listOf(
//        SuperHero("Spiderman", "Marvel", "Peter Parker", R.drawable.spiderman),
//        SuperHero("Wolverine", "Marvel", "James Howlett", R.drawable.logan),
//        SuperHero("Batman", "DC", "Bruce Wayne", R.drawable.batman),
//        SuperHero("Thor", "Marvel", "Thor Odinson", R.drawable.thor),
//        SuperHero("Flash", "DC", "Jay Garrick", R.drawable.flash),
//        SuperHero("Green Lantern", "DC", "Alan Scott", R.drawable.green_lantern),
//        SuperHero("Wonder Woman", "DC", "Princess Diana", R.drawable.wonder_woman)
//    )
//}

//@Composable
//fun SuperHeroGridView() {
//    val context = LocalContext.current
//    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
//        items(getSuperHeroes()) { superHero ->
//            ItemHero(superHero = superHero, onItemSelected = {
//                Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
//            })
//        }
//    }, contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp))
//}

//@Composable
//fun SuperHeroControlView() {
//    val context = LocalContext.current
//    val rvState = rememberLazyListState()
//    val coroutinesScope = rememberCoroutineScope()
//    Column {
//        LazyColumn(
//            state = rvState,
//            verticalArrangement = Arrangement.spacedBy(8.dp),
//            modifier = Modifier.weight(1f)
//        ) {
//            items(getSuperHeroes()) { superHero ->
//                ItemHero(superHero = superHero, onItemSelected = {
//                    Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
//                })
//            }
//        }
//        val showButton by remember {
//            derivedStateOf {
//                rvState.firstVisibleItemIndex > 0
//            }
//        }
//        if (showButton) {
//            Button(
//                onClick = {
//                    coroutinesScope.launch {
//                        rvState.animateScrollToItem(0)
//                    }
//                },
//                modifier = Modifier.align(Alignment.CenterHorizontally)
//            ) {
//                Text(text = "Boton")
//            }
//        }
//    }
//}