package oop_00000077278_HotasiRogateManurung_week09

fun main() {
    // Inisialisasi Data Uji sesuai kriteria
    val tradeHistory = listOf(
        TradeLog("BTCUSDT", "LONG", 20, 15.5, "CLOSED"),   // Profit
        TradeLog("ETHUSDT", "SHORT", 10, -5.0, "CLOSED"),  // Loss
        TradeLog("BTCUSDT", "LONG", 50, 25.0, "CLOSED"),   // Profit
        TradeLog("SOLUSDT", "SHORT", 12, -12.5, "CLOSED"), // Loss
        TradeLog("ETHUSDT", "LONG", 20, 0.0, "OPEN"),      // Masih jalan
        TradeLog("BTCUSDT", "LONG", 10, 8.0, "CLOSED")     // Profit
    )

    // Contoh verifikasi data (Opsional)
    println("Total log masuk: ${tradeHistory.size}")

    // Pipeline 1: Mengambil hanya transaksi yang sudah selesai
    val closedTrades = tradeHistory.filter { it.status == "CLOSED" }

// Verifikasi hasil (Cetak untuk memastikan filter bekerja)
    println("--- Pipeline 1: Filter Closed Trades ---")
    println("Total transaksi selesai: ${closedTrades.size}")
    closedTrades.forEach { println("${it.pair} | ROE: ${it.roe}%") }

    // Pipeline 2: Filter transaksi yang profit (ROE > 0)
    val winningTrades = closedTrades.filter { it.roe > 0.0 }

// Verifikasi hasil
    println("\n--- Pipeline 2: Winning Trades ---")
    println("Jumlah transaksi profit: ${winningTrades.size}")
    winningTrades.forEach { println("Winner: ${it.pair} dengan profit ${it.roe}%") }

    // Pipeline 3: Filter transaksi yang rugi atau impas (ROE <= 0)
    val losingTrades = closedTrades.filter { it.roe <= 0.0 }

// Verifikasi hasil
    println("\n--- Pipeline 3: Losing Trades ---")
    println("Jumlah transaksi loss: ${losingTrades.size}")
    losingTrades.forEach { println("Loss: ${it.pair} dengan ROE ${it.roe}%") }

    // Pipeline 4: Mengurutkan dari profit tertinggi dan mengubah formatnya menjadi String
    val topPerformersString = winningTrades
        .sortedByDescending { it.roe } // Mengurutkan berdasarkan ROE terbesar ke terkecil
        .map {
            "WIN [${it.pair} - ${it.position}]: +${it.roe}% ROE (Lev: ${it.leverage}x)"
        }

// Menampilkan hasil
    println("\n--- Pipeline 4: Top Performers String ---")
    topPerformersString.forEach { println(it) }

    // Pipeline 5: Mengurutkan dari kerugian terdalam dan mengubah format menjadi String
    val worstPerformersString = losingTrades
        .sortedBy { it.roe } // Mengurutkan dari nilai terkecil (minus paling besar)
        .map {
            "LOSS [${it.pair} - ${it.position}]: ${it.roe}% ROE (Lev: ${it.leverage}x)"
        }

// Menampilkan hasil
    println("\n--- Pipeline 5: Worst Performers String ---")
    worstPerformersString.forEach { println(it) }
}