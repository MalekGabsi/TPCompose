// In your MainActivity.kt (or relevant screen files)

package com.example.app0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
// Remove Scaffold, TopAppBar, Icon, IconButton imports from here if no longer used directly
// import androidx.compose.material3.Scaffold
// import androidx.compose.material3.TopAppBar
// import androidx.compose.material3.Icon
// import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.app0.ui.theme.AppThemedScaffold // Import the new themed Scaffold

// Your existing navigation state objects
data object EventDetailsScreenState
data object Inscription
data object NoContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // App0Theme is now applied within AppThemedScaffold
            val backStack = remember { mutableStateListOf<Any>(EventDetailsScreenState) }
            AppNavigator(backStack = backStack)
        }
    }
}

@Composable
fun AppNavigator(backStack: MutableList<Any>) {
    val currentScreen = backStack.lastOrNull()

    when (currentScreen) {
        is EventDetailsScreenState -> EventDetailsScreen( // Pass navigation lambdas
            onNavigateToInscription = { backStack.add(Inscription) },
            onNavigateToNoContent = { backStack.add(NoContent) }
        )
        is Inscription -> InscriptionDetailsScreen( // Renamed for clarity
            onBack = { if (backStack.size > 1) backStack.removeLastOrNull() }
        )
        is NoContent -> NoContentDetailsScreen( // Renamed for clarity
            onBack = { if (backStack.size > 1) backStack.removeLastOrNull() }
        )
        null -> Text("Error: Backstack is empty.")
    }
}

@Composable
fun EventDetailsScreen(
    onNavigateToInscription: () -> Unit,
    onNavigateToNoContent: () -> Unit
) {
    AppThemedScaffold(
        title = "Événements",
        // You can customize actions per screen if needed or pass lambdas
        onNavigationIconClick = { /* TODO: Handle Menu click */ },
        onActionIconClick = { /* TODO: Handle Favorite click */ }
    ) { scaffoldModifier -> // This modifier contains padding from Scaffold
        Column(
            modifier = scaffoldModifier // Apply the padding
                .fillMaxSize()
            // .padding(paddingValues) // Padding is now applied by scaffoldModifier
        ) {
            Image(
                painter = painterResource(id = R.drawable.event_image),
                contentDescription = "Event Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp)
                    .padding(top = 20.dp) // Specific padding for image
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(text = "Où : Ecole ingénieur ISIS")
                Text(text = "Quand : 24 octobre")
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp), // Specific padding for button row
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = onNavigateToInscription,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Inscription")
                }
                Button(
                    onClick = onNavigateToNoContent,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                ) {
                    Text(text = "Pas intéressé", color = Color.White)
                }
            }
        }
    }
}



