package oop_00000077278_HotasiRogateManurung_week02

class Hero(
    val name: String,
    val baseDamage: Int,
    var hp: Int = 100   // Default Argument
) {

    fun attack(targetName: String) {
        println("$name menebas $targetName!")
    }

    fun takeDamage(damage: Int) {
        hp -= damage

        // HP tidak boleh minus
        if (hp < 0) {
            hp = 0
        }
    }

    fun isAlive(): Boolean {
        return hp > 0
    }
}
