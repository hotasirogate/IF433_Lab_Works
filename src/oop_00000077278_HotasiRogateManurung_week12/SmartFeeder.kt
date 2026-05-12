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
}