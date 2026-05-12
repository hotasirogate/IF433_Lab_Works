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

    println("--- Simulasi Jadwal Makan Pagi ---")
    println("Stok saat ini: $currentKibbleStock gr")

    try {
        // Memanggil fungsi dengan permintaan 80 gr (melebihi stok 50 gr)
        currentKibbleStock = dispenseKibble(
            requestedGram = 80,
            availableGram = currentKibbleStock,
            isJammed = false
        )

        println("Sisa stok setelah makan pagi: $currentKibbleStock gr")

    } catch (e: DispenserJamException) {
        // Menangani jika hardware macet
        println("Error Hardware: ${e.message}")

    } catch (e: FoodEmptyException) {
        // Menangani jika stok tidak cukup (Ini yang akan terpanggil)
        println("Error Stok: ${e.message}")
        println("Silakan isi ulang wadah makanan Anda.")

    } catch (e: Exception) {
        // Menangani error tak terduga lainnya (termasuk IllegalArgumentException dari require)
        println("Error Tak Terduga: ${e.message}")

    } finally {
        println("--- Selesai Memproses Jadwal Makan Pagi ---")
    }
}
