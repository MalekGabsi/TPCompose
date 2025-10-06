package com.example.app0

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel: ViewModel() {

    val diceState = MutableStateFlow(0)

}