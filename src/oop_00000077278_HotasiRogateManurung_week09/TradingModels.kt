package oop_00000077278_HotasiRogateManurung_week09

data class TradeLog(
    val pair: String,      // Contoh: "BTCUSDT", "ETHUSDT"
    val position: String,  // Contoh: "LONG" atau "SHORT"
    val leverage: Int,     // Contoh: 10, 20, 50
    val roe: Double,       // Return on Equity dalam persentase (misal: 15.5 atau -5.0)
    val status: String     // "OPEN" atau "CLOSED"
)