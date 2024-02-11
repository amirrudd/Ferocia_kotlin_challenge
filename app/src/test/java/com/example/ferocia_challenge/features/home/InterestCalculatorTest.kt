package com.example.ferocia_challenge.features.home

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class InterestCalculatorTest {

    @Test
    fun testCalculateFinalDepositAtMaturity() {
        val result = InterestCalculator.calculateFinalDeposit(
            initialDeposit = 100000,
            interestRate = 4.1,
            investmentTerm = 3,
            interestPaymentFrequency = InterestPaymentFrequency.AT_MATURITY
        )
        assertEquals(112300, result)
    }

    @Test
    fun testCalculateFinalDepositYearly() {
        val result = InterestCalculator.calculateFinalDeposit(
            initialDeposit = 100000,
            interestRate = 4.1,
            investmentTerm = 3,
            interestPaymentFrequency = InterestPaymentFrequency.YEARLY
        )
        assertEquals(112811, result)
    }

    @Test
    fun testCalculateFinalDepositMonthly() {
        val result = InterestCalculator.calculateFinalDeposit(
            initialDeposit = 100000,
            interestRate = 4.1,
            investmentTerm = 3,
            interestPaymentFrequency = InterestPaymentFrequency.MONTHLY
        )
        assertEquals(113065, result)
    }

    @Test
    fun testCalculateFinalDepositQuarterly() {
        val result = InterestCalculator.calculateFinalDeposit(
            initialDeposit = 100000,
            interestRate = 4.1,
            investmentTerm = 3,
            interestPaymentFrequency = InterestPaymentFrequency.QUARTERLY
        )
        assertEquals(113018, result)
    }
}