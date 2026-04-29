package oop_00000077278_HotasiRogateManurung_week10

class WalletRepository<T> {

    // Menyimpan semua data generic
    private val items = mutableListOf<T>()

    // Menambahkan item ke repository
    fun add(item: T) {
        items.add(item)
    }

    // Mengambil semua item
    fun getAll(): List<T> {
        return items
    }
}