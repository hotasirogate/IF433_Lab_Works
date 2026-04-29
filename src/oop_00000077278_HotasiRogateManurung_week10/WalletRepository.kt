package oop_00000077278_HotasiRogateManurung_week10

interface Named {
    val name: String
}

class WalletRepository<T : Any> {

    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> {
        return items
    }

    // Fungsi filter hanya untuk item yang punya name
    fun searchByName(query: String): List<T> {
        return items.filter {
            it is Named && it.name.contains(query, ignoreCase = true)
        }
    }
}

