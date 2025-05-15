package com.udhay.skeucalc.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.udhay.skeucalc.model.CalculatorState
import org.mariuszgromada.math.mxparser.Expression

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(input: String) {
        when (input) {
            "=" -> calculateResult()
            "C" -> state = CalculatorState()
            else -> state = state.copy(expression = state.expression + input)
        }
    }

    private fun calculateResult() {
        try {
            val result = evaluateExpression(state.expression)
            state = state.copy(result = result)
        } catch (e: Exception) {
            state = state.copy(result = "Error")
        }
    }

    private fun evaluateExpression(expr: String): String {
        return try {
            val expression = Expression(expr)
            val result = expression.calculate()
            if (result.isNaN()) "Error" else result.toString()
        } catch (e: Exception) {
            "Error while parsing expression"
        }
    }
}