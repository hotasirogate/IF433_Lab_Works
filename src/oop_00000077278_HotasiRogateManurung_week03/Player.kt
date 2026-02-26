package oop_00000077278_HotasiRogateManurung_week03

class Player(val username: String) {

    // XP tidak boleh diakses dari luar
    private var xp: Int = 0

    // Computed Property
    val level: Int
        get() = (xp / 100) + 1

    fun addXp(amount: Int) {

        if (amount <= 0) {
            println("XP harus bernilai positif!")
            return
        }

        val oldLevel = level

        xp += amount

        val newLevel = level

        if (newLevel > oldLevel) {
            println("Level Up! Selamat $username naik ke level $newLevel")
        }
    }
}
