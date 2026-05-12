package oop_00000077278_HotasiRogateManurung_week12

fun dispenseKibble(requestedGram: Int, availableGram: Int, isJammed: Boolean): Int {
    // 1. Validasi input: Porsi harus positif
    require(requestedGram > 0) { "Porsi kibble harus lebih dari 0 gr" }

    // 2. Cek apakah mesin macet (isJammed)
    if (isJammed) {
        println("Peringatan: Mesin macet! Tidak ada kibble yang keluar.")
        return availableGram
    }

    // 3. Cek apakah stok cukup
    return if (availableGram >= requestedGram) {
        val remaining = availableGram - requestedGram
        println("Berhasil mengeluarkan $requestedGram gr. Sisa stok: $remaining gr.")
        remaining
    } else {
        // Jika stok kurang dari permintaan, keluarkan semua yang tersisa
        println("Stok tidak cukup. Mengeluarkan sisa stok: $availableGram gr.")
        0
    }
}

