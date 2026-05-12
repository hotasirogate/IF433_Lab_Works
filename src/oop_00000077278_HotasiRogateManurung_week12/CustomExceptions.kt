package oop_00000077278_HotasiRogateManurung_week12

class InsufficientFundsException(
    val amount: Double,
    val balance: Double
) : Exception("Attempted $amount, balance $balance")
