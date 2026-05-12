package oop_00000077278_HotasiRogateManurung_week12

class DispenserJamException(message: String) : Exception(message)
class FoodEmptyException(message: String) : Exception(message)

fun dispenseKibble(requestedGram: Int, availableGram: Int, isJammed: Boolean): Int {
    // 1. Validasi Input
    require(requestedGram > 0) { "Porsi kibble harus lebih dari 0 gr" }

    // 2. Validasi Hardware
    if (isJammed) {
        throw DispenserJamException("Mesin macet! Segera periksa wadah pengeluaran.")
    }

    // 3. Validasi Stok
    if (requestedGram > availableGram) {
        throw FoodEmptyException("Stok tidak cukup! Tersedia: $availableGram gr, Diminta: $requestedGram gr.")
    }

    // 4. Eksekusi jika berhasil
    println("Kibble berhasil dikeluarkan!")
    return availableGram - requestedGram
}

fun main() {
    var currentKibbleStock = 50

    println("--- Simulasi Jadwal Makan Pagi ---")

    try {
        currentKibbleStock = dispenseKibble(
            requestedGram = 80,
            availableGram = currentKibbleStock,
            isJammed = false
        )
    } catch (e: DispenserJamException) {
        println("Error Hardware: ${e.message}")
    } catch (e: FoodEmptyException) {
        println("Error Stok: ${e.message}")
    } catch (e: Exception) {
        println("Error Tak Terduga: ${e.message}")
    } finally {
        // Blok ini akan selalu dieksekusi apa pun yang terjadi
        println("Siklus pengecekan dispenser pagi selesai.")
    }

    println("\n--- Simulasi Jadwal Makan Sore ---")

    // Pemilik mengisi ulang alat sehingga stok menjadi 1000 gr
    var currentKibbleStock = 1000

    val result = runCatching {
        dispenseKibble(
            requestedGram = 30,
            availableGram = currentKibbleStock,
            isJammed = false
        )
    }

    // Mengolah hasil secara fungsional
    result.onSuccess { remainingStock ->
        currentKibbleStock = remainingStock
        println("Sore hari berhasil! Sisa stok sekarang: $currentKibbleStock gr")
    }.onFailure { error ->
        when (error) {
            is DispenserJamException -> println("Gagal Sore: Hardware macet.")
            is FoodEmptyException -> println("Gagal Sore: Stok habis.")
            else -> println("Gagal Sore: ${error.message}")
        }
    }

    // Inisialisasi stok setelah isi ulang oleh pemilik
    var currentKibbleStock = 1000
    val requestedSore = 30

    println("--- Simulasi Jadwal Makan Sore ---")

    // Menjalankan operasi dengan gaya fungsional (runCatching)
    runCatching {
        dispenseKibble(
            requestedGram = requestedSore,
            availableGram = currentKibbleStock,
            isJammed = false // Alat dalam kondisi normal
        )
    }.onSuccess { newStock ->
        // Jika berhasil, perbarui stok dan beri laporan
        currentKibbleStock = newStock
        println("Makan sore sukses! Sisa stok kibble: $currentKibbleStock gr")
    }.onFailure { error ->
        // Jika gagal (macet/habis), berikan peringatan dan solusi alternatif
        println("Peringatan ke Pemilik: ${error.message}")
        println("(Opsional: Berikan chicken jerky secara manual)")
    }
}