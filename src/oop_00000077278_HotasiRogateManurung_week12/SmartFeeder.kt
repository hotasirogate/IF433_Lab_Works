package oop_00000077278_HotasiRogateManurung_week12

// 2. Fungsi Utama Engine
fun dispenseKibble(requestedGram: Int, availableGram: Int, isJammed: Boolean): Int {
    // Validasi Input (Gunakan standar Kotlin require)
    require(requestedGram > 0) { "Porsi kibble harus lebih dari 0 gr" }

    // Validasi Hardware
    if (isJammed) {
        throw DispenserJamException("Mesin macet! Segera periksa wadah pengeluaran.")
    }

    // Validasi Stok

    println("Kibble berhasil dikeluarkan!")
    return availableGram - requestedGram
}

fun main() {
    // Inisialisasi stok awal
    var currentKibbleStock = 50

    // --- SIMULASI JADWAL MAKAN PAGI (Try-Catch-Finally) ---
    println("--- Simulasi Jadwal Makan Pagi ---")
    println("Stok awal: $currentKibbleStock gr")

    try {
        // Simulasi ini akan memicu FoodEmptyException karena 80 > 50
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
        println("Siklus pengecekan dispenser pagi selesai.")
    }

    // --- SIMULASI JADWAL MAKAN SORE (runCatching) ---
    println("\n--- Simulasi Jadwal Makan Sore ---")

    // Pemilik mengisi ulang alat
    currentKibbleStock = 1000
    println("Pemilik mengisi ulang stok menjadi: $currentKibbleStock gr")

    val requestedSore = 30

    runCatching {
        dispenseKibble(
            requestedGram = requestedSore,
            availableGram = currentKibbleStock,
            isJammed = false
        )
    }.onSuccess { newStock ->
        currentKibbleStock = newStock
        println("Makan sore sukses! Sisa stok kibble: $currentKibbleStock gr")
    }.onFailure { error ->
        println("Peringatan ke Pemilik: ${error.message}")
        println("(Opsional: Berikan chicken jerky secara manual)")
    }
}