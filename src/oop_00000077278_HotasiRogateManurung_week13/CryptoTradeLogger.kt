package oop_00000077278_HotasiRogateManurung_week13
import java.io.File
import java.io.FileNotFoundException

data class TradeRecord(
    val id: Int,
    val symbol: String,
    val type: String,
    val margin: Double,
    val pnl: Double
)

fun TradeRecord.toCsv(): String {
    return "$id,$symbol,$type,$margin,$pnl"
}

fun fromCsvTrade(line: String): TradeRecord? {
    return try {

        val tokens = line.split(",")

        val id = tokens[0].trim().toInt()
        val symbol = tokens[1].trim()
        val type = tokens[2].trim()
        val margin = tokens[3].trim().toDouble()
        val pnl = tokens[4].trim().toDouble()

        TradeRecord(id, symbol, type, margin, pnl)
    } catch (e: Exception) {
        println("(Log) Data korup diabaikan: $line")
        null
    }
}

fun saveTrades(trades: List<TradeRecord>, path: String) {
    try {
        // Membuka PrintWriter secara aman. File akan otomatis di-close setelah blok selesai.
        File(path).printWriter().use { writer ->
            trades.forEach { trade ->
                // Menulis hasil dari extension function toCsv() ke dalam file
                writer.println(trade.toCsv())
            }
        }
        println("(Log) Berhasil menyimpan ${trades.size} data transaksi ke $path")
    } catch (e: Exception) {
        println("(Log) Gagal menyimpan data ke file: ${e.message}")
    }
}

fun loadTrades(path: String): List<TradeRecord> {
    return try {
        // 1. Membaca seluruh baris teks di dalam file
        // 2. Melakukan mapping dan otomatis mengabaikan nilai null (data korup)
        File(path).readLines().mapNotNull { line ->
            fromCsvTrade(line)
        }
    } catch (e: FileNotFoundException) {
        println("(Log) Peringatan: File $path tidak ditemukan. Membuat daftar kosong baru.")
        emptyList()
    } catch (e: Exception) {
        println("(Log) Gagal membaca file karena kesalahan sistem: ${e.message}")
        emptyList()
    }
}