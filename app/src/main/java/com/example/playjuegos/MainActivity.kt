package com.example.playjuegos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.playjuegos.ui.theme.PlayJuegosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlayJuegosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Home") {
                        composable ("Home") { HomeScreen(navController, Modifier.padding(innerPadding)) }
                        composable ("NewPlayer") { NewPlayerScreen() }
                    }


                    //HomeScreen(navController, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// ----- COMPONENTES -----

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title()
        Spacer(modifier = Modifier.height(50.dp))

        val texts = arrayOf("Play", "New Player", "Preferences", "About")
        for (i in texts) {
            HomeButton(text = i)
        }
    }
}

@Composable
fun Title(modifier: Modifier = Modifier) {
    Text(
        text = "Play Juegos",
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary,
        fontSize = 50.sp,
        fontStyle = FontStyle.Italic
    )
}

@Composable
fun HomeButton(text: String, modifier: Modifier = Modifier) {
    Button (
        onClick = {},
        modifier = modifier.width(300.dp).height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(
            text = text
        )
    }
    Spacer(Modifier.height(20.dp))
}

@Composable
fun NewPlayerScreen(modifier: Modifier = Modifier) {
    Text(text = "New Player Screen")
}

// ----- PREVIEWS -----

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    PlayJuegosTheme {
        Title()
    }
}



// ----- TEMPLATES -----

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlayJuegosTheme {
        Greeting("Android")
    }
}