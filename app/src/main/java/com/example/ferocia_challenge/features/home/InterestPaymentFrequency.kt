package com.example.ferocia_challenge.features.home

enum class InterestPaymentFrequency(val frequency: Int, val printableName: String) {
    YEARLY(1, "Yearly"),
    QUARTERLY(4, "Quarterly"),
    MONTHLY(12, "Monthly"),
    AT_MATURITY(-1, "At Maturity")
}