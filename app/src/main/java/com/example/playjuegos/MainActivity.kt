package com.example.playjuegos

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
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
    val portrait = LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT

    if (portrait) {
        Column (
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title()
            Spacer(modifier = Modifier.height(50.dp))

            val texts = arrayOf("Play", "New Player", "Preferences", "About")
            HomeButton("Play")
            HomeButton("New Player", navController = navController, link="NewPlayer")
            HomeButton("Preferences")
            HomeButton("About")
        }
    }
    else {
        Column (
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title()
            Spacer(modifier = Modifier.height(50.dp))

            val texts = arrayOf("Play", "New Player", "Preferences", "About")
            Row {
                HomeButton("Play")
                HomeButton("New Player")
            }
            Spacer(modifier.height(-10.dp))
            Row {
                HomeButton("Preferences")
                HomeButton("About")
            }
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
fun HomeButton(text: String, modifier: Modifier = Modifier, link: String? = null, navController: NavHostController? = null) {
    Button (
        onClick = { navController?.navigate(link ?: "") },
        modifier = modifier
            .width(300.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(
            text = text
        )
    }
    Spacer(Modifier
        .height(20.dp)
        .width(20.dp))
}

@Composable
fun NewPlayerScreen(modifier: Modifier = Modifier) {
    var nameFieldState by remember { mutableStateOf(" ") }
    var surnameFieldState by remember { mutableStateOf(" ") }
    var nickFieldState by remember { mutableStateOf(" ") }
    var phoneFieldState by remember { mutableStateOf(" ") }
    var emailFieldState by remember { mutableStateOf(" ") }

    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Icono de Perfil",
                tint = Color.DarkGray,
                modifier = Modifier.size(60.dp)
            )
            TextField(
                value = nameFieldState,
                onValueChange = {nameFieldState = it},
                label = { Text(text = "Nombre") }
            )
        }
        Spacer(modifier = Modifier.size(25.dp))
        Row {
            Spacer(modifier = Modifier.size(60.dp))
            TextField(
                value = surnameFieldState,
                onValueChange = {surnameFieldState = it},
                label = { Text(text = "Apellido") }
            )
        }
        Spacer(modifier = Modifier.size(25.dp))
        Row {
            Spacer(modifier = Modifier.size(60.dp))
            TextField(
                value = nickFieldState,
                onValueChange = {nickFieldState = it},
                label = { Text(text = "Apodo") }
            )
        }
        Spacer(modifier = Modifier.size(25.dp))
        Image(
            painter = painterResource(id = R.drawable.android),
            contentDescription = "Imágen de Android",
            modifier = Modifier.requiredSize(150.dp)
        )
        Spacer(modifier = Modifier.size(25.dp))
        Row {
            Icon(
                imageVector = Icons.Rounded.Phone,
                contentDescription = "Icono de Teléfono",
                tint = Color.DarkGray,
                modifier = Modifier.size(60.dp)
            )
            TextField(
                value = phoneFieldState,
                onValueChange = {phoneFieldState = it},
                label = { Text(text = "Teléfono") }
            )
        }
        Spacer(modifier = Modifier.size(25.dp))
        Row {
            Icon(
                imageVector = Icons.Rounded.Email,
                contentDescription = "Icono de Correo",
                tint = Color.DarkGray,
                modifier = Modifier.size(60.dp)
            )
            TextField(
                value = emailFieldState,
                onValueChange = {emailFieldState = it},
                label = { Text(text = "Correo Electrónico") }
            )
        }
        Spacer(modifier = Modifier.size(50.dp))
        Button(
            onClick = {},
            modifier = modifier
                .width(300.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = "Guardar Cambios"
            )
        }
    }
}

// ----- PREVIEWS -----

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    PlayJuegosTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "Home") {
                composable ("Home") { HomeScreen(navController, Modifier.padding(innerPadding)) }
                composable ("NewPlayer") { NewPlayerScreen() }
            }
        }
    }
}

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