package com.example.ferocia_challenge.features.home

import kotlin.math.pow
import kotlin.math.roundToInt

class InterestCalculator {

    companion object {
        fun calculateFinalDeposit(
            initialDeposit: Int,
            interestRate: Double,
            investmentTerm: Int,
            interestPaymentFrequency: InterestPaymentFrequency
        ): Int {
            val r = interestRate / 100 // Convert percentage to decimal

            //Calculate pure interest over time
            return if (interestPaymentFrequency == InterestPaymentFrequency.AT_MATURITY) {
                ((initialDeposit * r * investmentTerm) + initialDeposit).roundToInt()
            } else {
                // Calculate compound interest at frequency interval payment
                val n = interestPaymentFrequency.frequency
                (initialDeposit * (1 + r / n).pow(n * investmentTerm)).roundToInt()
            }
        }
    }
}