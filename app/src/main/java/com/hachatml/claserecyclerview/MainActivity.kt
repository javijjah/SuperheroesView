package com.hachatml.claserecyclerview

import android.graphics.Paint.Align
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hachatml.claserecyclerview.Views.SuperHero
import com.hachatml.claserecyclerview.ui.theme.ClaseRecyclerViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClaseRecyclerViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Ejercicio 1
                    //SimpleRecyclerView()
                    //Ejercicio 2 hasta apartado 6
                    //SuperHeroView()
                    SuperHeroViewColumn()
                }
            }
        }
    }
}

//Ejercicio 1
@Composable
fun SimpleRecyclerView() {
    val Profesores = listOf("Diego", "Javi", "Jose Luis", "Gabriel")
    LazyColumn {
        item { Text(text = "Header") }
        items(3) {
            Text(text = "Este es el item $it")
        }
        items(Profesores) {
            Text(text = "Hola me llamo $it")
        }
        item { Text(text = "Footer") }
        item {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Hola")
            }
        }
    }
}

@Composable
fun ItemHero(Superhero: Superhero, onItemSelected: (Superhero) -> Unit) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .padding(20.dp)
            .clickable { onItemSelected(Superhero) },
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Column {
            Image(
                painter = painterResource(id = Superhero.photo),
                contentDescription = "Imagen de ${Superhero.superheroName}",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = Superhero.superheroName, modifier = Modifier.padding(10.dp))
            Text(text = Superhero.realName, modifier = Modifier.padding(10.dp))
            Text(
                text = Superhero.publisher,
                modifier = Modifier.padding(5.dp),
                fontSize = 10.sp,
                textAlign = TextAlign.Right
            )
        }
    }
}

@Composable
fun SuperHeroView() {
    var context = LocalContext.current
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(getSuperheroes()) {
            ItemHero(Superhero = it
            ) {
                Toast.makeText(context, it.realName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

fun getSuperheroes(): MutableList<Superhero> {
    var SuperheroList = mutableListOf<Superhero>()
    SuperheroList.add(Superhero("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman))
    SuperheroList.add(Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan))
    SuperheroList.add(Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman))
    SuperheroList.add(Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor))
    SuperheroList.add(Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash))
    SuperheroList.add(Superhero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern))
    SuperheroList.add(Superhero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman))
    return SuperheroList
}

//Hasta aquí Ejercicio 2 hasta el apartado 6
//Apartado7
@Composable
fun SuperHeroViewColumn() {
    var context = LocalContext.current
    LazyColumn(
    ) {
        items(getSuperheroes()) {
            ItemHero(Superhero = it) {
                Toast.makeText(context, it.realName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

data class Superhero(
    var superheroName: String,
    var realName: String,
    var publisher: String,
    @DrawableRes var photo: Int
) {

}
