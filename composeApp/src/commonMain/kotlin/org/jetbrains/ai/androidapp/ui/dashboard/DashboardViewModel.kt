package org.jetbrains.ai.androidapp.ui.dashboard

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashboardViewModel : ViewModel() {
    private val _text = MutableStateFlow("This is dashboard Fragment")
    val text: StateFlow<String> = _text.asStateFlow()
}