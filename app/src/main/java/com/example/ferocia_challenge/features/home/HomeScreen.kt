package com.example.ferocia_challenge.features.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ferocia_challenge.ui.theme.Ferocia_challengeTheme

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    DisplayState(
        state = state,
        initialDepositChanged = viewModel::initialDepositChanged,
        interestRateChanged = viewModel::interestRateChanged,
        investmentTermChanged = viewModel::investmentTermChanged,
        onFrequencyClicked = viewModel::onFrequencyClicked
    )
}

@Composable
private fun DisplayState(
    state: HomeModel,
    initialDepositChanged: (String) -> Unit,
    interestRateChanged: (String) -> Unit,
    investmentTermChanged: (String) -> Unit,
    onFrequencyClicked: (InterestPaymentFrequency) -> Unit
) {
    var initialDeposit by remember { mutableStateOf("") }
    var interestRate by remember { mutableStateOf("") }
    var investmentTerm by remember { mutableStateOf("") }

    Scaffold() { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    label = { Text(text = "Initial Deposit:") },
                    value = initialDeposit,
                    onValueChange = {
                        initialDeposit = it
                        if (it.isNotEmpty()) initialDepositChanged(it)
                    }
                )

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    label = { Text(text = "Interest Rate:") },
                    value = interestRate,
                    onValueChange = {
                        interestRate = it
                        if (it.isNotEmpty()) interestRateChanged(it)
                    })

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    label = { Text(text = "Investment Term:") },
                    value = investmentTerm,
                    onValueChange = {
                        investmentTerm = it
                        if (it.isNotEmpty()) investmentTermChanged(it)
                    })

                Row(modifier = Modifier.fillMaxWidth()) {
                    TextButton(
                        modifier = Modifier
                            .padding(8.dp),
                        onClick = {
                            onFrequencyClicked(InterestPaymentFrequency.MONTHLY)
                        }) {
                        Text(text = InterestPaymentFrequency.MONTHLY.printableName)
                    }
                    TextButton(
                        modifier = Modifier
                            .padding(8.dp),
                        onClick = {
                            onFrequencyClicked(InterestPaymentFrequency.QUARTERLY)
                        }) {
                        Text(text = InterestPaymentFrequency.QUARTERLY.printableName)
                    }
                    TextButton(
                        modifier = Modifier
                            .padding(8.dp),
                        onClick = {
                            onFrequencyClicked(InterestPaymentFrequency.YEARLY)
                        }) {
                        Text(text = InterestPaymentFrequency.YEARLY.printableName)
                    }
                    TextButton(
                        modifier = Modifier
                            .padding(8.dp),
                        onClick = {
                            onFrequencyClicked(InterestPaymentFrequency.AT_MATURITY)
                        }) {
                        Text(text = InterestPaymentFrequency.AT_MATURITY.printableName)
                    }
                }

                Text(modifier = Modifier.padding(12.dp),
                    text = state.finalAmount?.let { "\$$it on the above inputs, interest paid ${state.interestPaymentFrequency.printableName}" }
                        ?: "")

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowScreen() {
    Ferocia_challengeTheme {
        DisplayState(
            HomeModel(10000, 1.1, 3, InterestPaymentFrequency.AT_MATURITY),
            {}, {}, {}, {})
    }
}
