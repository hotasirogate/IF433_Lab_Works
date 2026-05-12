package oop_00000077278_HotasiRogateManurung_week12

/**
 * Definisi Custom Exceptions
 */
class DispenserJamException(message: String) : Exception(message)
class FoodEmptyException(message: String) : Exception(message)

fun dispenseKibble(requestedGram: Int, availableGram: Int, isJammed: Boolean): Int {
    // 1. Validasi Input: Porsi harus > 0
    require(requestedGram > 0) { "Porsi kibble harus lebih dari 0 gr" }

    // 2. Validasi Hardware: Cek jika macet
    if (isJammed) {
        throw DispenserJamException("Mesin macet! Segera periksa wadah pengeluaran.")
    }

    // 3. Validasi Stok: Cek jika permintaan melebihi stok yang tersedia
    if (requestedGram > availableGram) {
        throw FoodEmptyException("Stok tidak cukup! Tersedia: $availableGram gr, Diminta: $requestedGram gr.")
    }

    // 4. Jika semua validasi lolos
    println("Kibble berhasil dikeluarkan!")
    return availableGram - requestedGram
}

fun main() {
    // Contoh Skenario: Berhasil
    try {
        val sisaStok = dispenseKibble(50, 100, false)
        println("Sisa stok sekarang: $sisaStok gr")
    } catch (e: Exception) {
        println("Terjadi kesalahan: ${e.message}")
    }

    // Contoh Skenario: Stok Kurang
    try {
        dispenseKibble(200, 150, false)
    } catch (e: FoodEmptyException) {
        println("Error Log: ${e.message}")
    }
}

