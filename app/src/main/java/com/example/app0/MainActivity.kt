package com.example.app0

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import com.example.app0.ui.theme.App0Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.ui.NavDisplay

data object Inscription
data object NoContent
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App0Theme {
                EventScreen()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventScreen() {
    // Création du backstack pour gérer la navigation
    val backStack = remember { mutableStateListOf<Any>(Inscription) }

    // Scaffold avec une topbar
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Événements") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite"
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Affichage de l'image d'événement
                Image(
                    painter = painterResource(id = R.drawable.event_image),
                    contentDescription = "Event Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .padding(top = 20.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Column(modifier = Modifier.padding(horizontal = 120.dp)) {
                    Text(text = "Où : Ecole ingénieur ISIS")
                    Text(text = "Quand : 24 octobre")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Affichage des boutons d'action
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(onClick = { backStack.add(NoContent) }, modifier = Modifier.weight(1f)) {
                        Text(text = "Inscription")
                    }
                    Button(
                        onClick = { backStack.add(NoContent) },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                    ) {
                        Text(text = "Pas intéressé", color = Color.White)
                    }
                }
            }
            navDisplay(backStack)
        }

    )
}



@Composable
fun navDisplay(backStack: MutableList<Any>) {
    // On récupère le dernier élément du backStack
    val currentScreen = backStack.lastOrNull()

    // Affichage de l'écran correspondant
    when (currentScreen) {
        is Inscription -> Inscription(
            onClick = {
                // Retirer l'écran courant du backStack si plus d'un élément existe
                if (backStack.size > 1) backStack.removeLastOrNull()
            }
        )
        is NoContent -> NoContent(
            onClick = {
                // Retirer l'écran courant du backStack si plus d'un élément existe
                if (backStack.size > 1) backStack.removeLastOrNull()
            }
        )
    }
}





