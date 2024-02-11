package com.example.ferocia_challenge.features.home

data class HomeModel(
    val initialDeposit: Int = 0,
    val interestRate: Double = 0.0,
    val investmentTerm: Int = 0,
    val interestPaymentFrequency: InterestPaymentFrequency = InterestPaymentFrequency.AT_MATURITY,
    val finalAmount: Int? = null
)
