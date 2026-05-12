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
    // Inisialisasi stok awal
    var currentKibbleStock = 50

    println("--- Smart Feeder System Started ---")
    println("Stok awal: $currentKibbleStock gr")

    // Di sini kamu bisa menambahkan logika simulasi pemanggilan fungsi dispenseKibble
    // Contoh penggunaan:
    try {
        val porsi = 20
        currentKibbleStock = dispenseKibble(porsi, currentKibbleStock, false)
        println("Berhasil memberi makan. Stok sekarang: $currentKibbleStock gr")
    } catch (e: Exception) {
        println("Gagal mengeluarkan kibble: ${e.message}")
    }
}
