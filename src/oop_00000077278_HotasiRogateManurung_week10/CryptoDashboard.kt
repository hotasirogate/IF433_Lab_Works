package oop_00000077278_HotasiRogateManurung_week10

fun main() {

    // Inisialisasi repository untuk Coin
    val coinRepo = WalletRepository<Coin>()

    // Contoh tambahan (biar kelihatan jalan)
    coinRepo.add(Coin("Bitcoin", 1.5))
    coinRepo.add(Coin("Ethereum", 3.0))

    println("Daftar Coin:")
    println(coinRepo.getAll())

    // Menambahkan minimal 3 koin
    coinRepo.add(Coin("BTC", 0.75))
    coinRepo.add(Coin("ETH", 2.5))
    coinRepo.add(Coin("USDT", 1000.0))

    // Simulasi response jaringan
    val response = ApiResponse("200 OK", coinRepo.getAll())

    println("Response API:")
    println("Status: ${response.status}")
    println("Data:")
    response.data.forEach {
        println("Nama: ${it.name}, Balance: ${it.balance}")
    }

    println("Daftar Coin:")
    coinRepo.getAll().forEach {
        println("Nama: ${it.name}, Balance: ${it.balance}")
    }
}