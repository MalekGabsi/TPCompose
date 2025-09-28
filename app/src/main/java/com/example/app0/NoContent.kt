package com.example.app0

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.app0.ui.theme.AppThemedScaffold

@Composable
fun NoContentDetailsScreen(onBack: () -> Unit) {
    AppThemedScaffold(
        title = "Information",
        showNavigationIcon = true,
        onNavigationIconClick = onBack, // Use TopAppBar's nav icon for back
        showActions = false
    ) { scaffoldModifier ->
        Box(
            modifier = scaffoldModifier // Apply the padding
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Contenu pour 'Pas intéressé'")
        }
    }
}
