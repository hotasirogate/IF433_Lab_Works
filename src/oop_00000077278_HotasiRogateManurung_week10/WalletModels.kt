package oop_00000077278_HotasiRogateManurung_week10

data class Coin(
    override val name: String,
    val balance: Double
) : Named

// Data class untuk menyimpan informasi transaksi
data class Transaction(
    val id: String,
    val amount: Double
)