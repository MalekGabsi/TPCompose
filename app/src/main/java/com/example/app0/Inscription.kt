package com.example.app0

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.app0.ui.theme.AppThemedScaffold

@Composable
fun InscriptionDetailsScreen(onBack: () -> Unit) {
    AppThemedScaffold(
        title = "Inscription",
        showNavigationIcon = true, // Or false if not needed for this screen
        onNavigationIconClick = onBack, // Use TopAppBar's nav icon for back
        showActions = false // Example: Hide favorite icon here
    ) { scaffoldModifier ->
        Box(
            modifier = scaffoldModifier // Apply the padding
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Page d'inscription")
            // Add a dedicated back button inside the content if the TopAppBar nav icon is used for something else
            // Button(onClick = onBack) { Text("Go Back") }
        }
    }
}