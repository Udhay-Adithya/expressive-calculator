package com.udhay.skeucalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.udhay.skeucalc.ui.screen.CalculatorScreen
import com.udhay.skeucalc.ui.theme.SkeucalcTheme
import com.udhay.skeucalc.viewmodel.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SkeucalcTheme {
                val viewModel: CalculatorViewModel = viewModel()
                CalculatorScreen(viewModel = viewModel)
            }
        }
    }
}