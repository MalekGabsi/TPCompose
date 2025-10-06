package com.example.app0

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.app0.ui.theme.AppThemedScaffold
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app0.R
@Composable
fun InscriptionDetailsScreen(onBack: () -> Unit) {
    val viewModel = viewModel<MainViewModel>()
    val diceState by viewModel.diceState.collectAsStateWithLifecycle()

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

        )
        {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp) // espace régulier e
            ) {


            Text(
                text = "Gérer votre numéro de passage !",

            )
                val diceRes = when(diceState) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }
            Image(
                painter = painterResource(id = R.drawable.dice_1),
                contentDescription = "Dé avec face 1",
                modifier = Modifier
                    .size(300.dp)
            )
            Button(onClick = { /*TODO*/ }) {
                Text("Roll  \uD83C\uDFB2")
            }
            }
        }
    }
}