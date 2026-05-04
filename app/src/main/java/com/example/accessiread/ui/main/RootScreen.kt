package com.example.accessiread.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.accessiread.data.model.AppLanguage

@Composable
fun RootScreen(vm: RootViewModel) {
    val state by vm.state.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(if (state.isSetupComplete) "Setup complete" else "Choose preferred language")
        Spacer(Modifier.height(12.dp))
        Button(onClick = { vm.completeSetup(AppLanguage.ENGLISH) }) { Text("English") }
        Button(onClick = { vm.completeSetup(AppLanguage.MARATHI) }) { Text("Marathi") }
        Spacer(Modifier.height(16.dp))
        Text("Auto read")
        Switch(checked = state.settings.autoRead, onCheckedChange = vm::toggleAutoRead)
        Text("Continuous mode")
        Switch(checked = state.settings.continuousMode, onCheckedChange = vm::toggleContinuous)
    }
}
