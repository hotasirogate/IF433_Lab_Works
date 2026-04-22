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

    // Pipeline Tambahan: Mengambil daftar koin unik yang pernah ditradingkan
    val uniquePairs = tradeHistory
        .map { it.pair } // Mengekstrak hanya nama pair-nya (String)
        .toSet()         // Mengonversi List menjadi Set untuk menghapus duplikat

// Menampilkan hasil
    println("\n--- Daftar Koin yang Pernah Ditradingkan ---")
    println("Koin: $uniquePairs")

    // Mencetak Header Dashboard
    println("\n==============================================")
    println("===         CRYPTO TRADING DASHBOARD       ===")
    println("==============================================")

// Menampilkan Top Performers (Cuan)
    println("\n[ TOP PERFORMERS ]")
    topPerformersString.forEach { println(it) }

// Menampilkan Worst Performers (Boncos)
    println("\n[ WORST PERFORMERS ]")
    worstPerformersString.forEach { println(it) }

// Menampilkan Statistik Aset
    println("\n[ ASSETS TRADED ]")
    println("Pairs: ${uniquePairs.joinToString(", ")}")

    println("\n==============================================")
    println("Dashboard Status: Updated Successfully")

    // Melanjutkan pencetakan dari langkah sebelumnya...

    // 1. Menampilkan baris loss menggunakan forEach
    println("\n[ WORST PERFORMERS ]")
    worstPerformersString.forEach { barisLoss ->
        println(barisLoss)
    }

    // 2. Mencetak koin unik yang pernah ditradingkan
    println("\n[ UNIQUE PAIRS TRADED ]")
    println("Pairs: $uniquePairs")

    // Penutup Dashboard
    println("\n==============================================")
    println("Dashboard Generated at: ${java.time.LocalDateTime.now()}")
    println("==============================================")

    // Pastikan TradeLog sudah didefinisikan (di file yang sama atau TradingModels.kt)
    data class TradeLog(
        val pair: String,
        val position: String,
        val leverage: Int,
        val roe: Double,
        val status: String
    )

    fun main() {
        // 2. Inisialisasi Data Uji
        val tradeHistory = listOf(
            TradeLog("BTCUSDT", "LONG", 20, 15.5, "CLOSED"),
            TradeLog("ETHUSDT", "SHORT", 10, -5.2, "CLOSED"),
            TradeLog("BTCUSDT", "LONG", 50, 25.0, "CLOSED"),
            TradeLog("SOLUSDT", "SHORT", 12, -12.5, "CLOSED"),
            TradeLog("ETHUSDT", "LONG", 20, 0.0, "OPEN"),      // Tidak boleh muncul di hasil akhir
            TradeLog("BTCUSDT", "LONG", 10, 8.0, "CLOSED")
        )

        // 3. Pipeline 1: Ekstraksi Data Valid (Filter CLOSED)
        val closedTrades = tradeHistory.filter { it.status == "CLOSED" }

        // 4. Pipeline 2: Memisahkan Winning Trades (ROE > 0)
        val winningTrades = closedTrades.filter { it.roe > 0 }

        // 5. Pipeline 3: Memisahkan Losing Trades (ROE <= 0)
        val losingTrades = closedTrades.filter { it.roe <= 0 }

        // 6. Pipeline 4: Analisis Koin Profit Tertinggi (Sorting & Mapping)
        val topPerformersString = winningTrades
            .sortedByDescending { it.roe }
            .map { "WIN [${it.pair} - ${it.position}]: +${it.roe}% ROE (Lev: ${it.leverage}x)" }

        // 7. Pipeline 5: Analisis Koin Loss (Sorting & Mapping)
        val worstPerformersString = losingTrades
            .sortedBy { it.roe }
            .map { "LOSS [${it.pair} - ${it.position}]: ${it.roe}% ROE (Lev: ${it.leverage}x)" }

        // 8. Pipeline Tambahan: Ekstraksi Unik (Set)
        val uniquePairs = tradeHistory
            .map { it.pair }
            .toSet()

        // 9 & 10. Menampilkan Dashboard Utama
        println("=== CRYPTO TRADING DASHBOARD ===")

        println("\n[ TOP PERFORMERS ]")
        topPerformersString.forEach { println(it) }

        println("\n[ WORST PERFORMERS ]")
        worstPerformersString.forEach { println(it) }

        println("\n[ ASSETS TRADED ]")
        println("Unique Pairs: $uniquePairs")

        println("\n================================")
    }
}