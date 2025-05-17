package com.udhay.skeucalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.udhay.skeucalc.ui.screen.CalculatorScreen
import com.udhay.skeucalc.ui.theme.SkeucalcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SkeucalcTheme {
                CalculatorScreen()
            }
        }
    }
}