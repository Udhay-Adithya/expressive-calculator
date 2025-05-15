package com.udhay.skeucalc.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import com.udhay.skeucalc.ui.components.CalculatorButton
import com.udhay.skeucalc.viewmodel.CalculatorViewModel

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel) {
    val state = viewModel.state

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = state.expression,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = state.result,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(16.dp))

        val buttons = listOf(
            listOf("7", "8", "9", "÷"),
            listOf("4", "5", "6", "×"),
            listOf("1", "2", "3", "-"),
            listOf("0", ".", "=", "+"),
            listOf("C")
        )

        buttons.forEach { row ->
            Row(modifier = Modifier.fillMaxWidth().weight(1f)) {
                row.forEach { label ->
                    CalculatorButton(
                        label = label,
                        onClick = { viewModel.onAction(label) },
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                    )
                }
            }
        }
    }
}
