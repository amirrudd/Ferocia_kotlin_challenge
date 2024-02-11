package com.example.ferocia_challenge.features.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private var interestModel = HomeModel()
    private val _state = MutableStateFlow(interestModel)
    val state = _state.asStateFlow()

    fun onFrequencyClicked(frequency: InterestPaymentFrequency) {
        val finalAmount = InterestCalculator.calculateFinalDeposit(
            initialDeposit = interestModel.initialDeposit,
            interestRate = interestModel.interestRate,
            investmentTerm = interestModel.investmentTerm,
            interestPaymentFrequency = frequency
        )
        interestModel =
            interestModel.copy(finalAmount = finalAmount, interestPaymentFrequency = frequency)
        _state.tryEmit(interestModel)
    }

    fun initialDepositChanged(initialDeposit: String) {
        // Assumption: edge cases not taken into account like when input is not castable to Int eg String
        interestModel = interestModel.copy(initialDeposit = initialDeposit.toInt())
    }

    fun investmentTermChanged(term: String) {
        interestModel = interestModel.copy(investmentTerm = term.toInt())
    }

    fun interestRateChanged(rate: String) {
        interestModel = interestModel.copy(interestRate = rate.toDouble())
    }
}