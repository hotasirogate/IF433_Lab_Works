package oop_00000077278_HotasiRogateManurung_week03

fun main() {

    val player = Player("Hotasi")

    player.addXp(50)
    println("Level sekarang: ${player.level}")

    player.addXp(60)
    println("Level sekarang: ${player.level}")

    player.addXp(200)
    println("Level sekarang: ${player.level}")
}
