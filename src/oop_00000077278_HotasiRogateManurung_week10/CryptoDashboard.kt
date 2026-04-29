package oop_00000077278_HotasiRogateManurung_week10

fun main() {

    // Inisialisasi repository untuk Coin
    val coinRepo = WalletRepository<Coin>()

    // Contoh tambahan (biar kelihatan jalan)
    coinRepo.add(Coin("Bitcoin", 1.5))
    coinRepo.add(Coin("Ethereum", 3.0))

    println("Daftar Coin:")
    println(coinRepo.getAll())
}