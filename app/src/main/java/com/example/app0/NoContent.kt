package com.example.app0

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun NoContent(onClick: () -> Unit) {
    Text("Second écran")
    Button(onClick = onClick) {
        Text("Ecran précédent")
    }
}