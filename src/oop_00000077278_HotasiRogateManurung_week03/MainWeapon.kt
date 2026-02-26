package oop_00000077278_HotasiRogateManurung_week03

import oop_00000077278_HotasiRogateManurung_week02.Weapon

fun main() {

    val sword = Weapon("Dragon Slayer", 600)

    println("Nama: ${sword.name}")
    println("Damage: ${sword.damage}")
    println("Tier: ${sword.tier}")

    println("\nCoba set damage -50")
    sword.damage = -50
    println("Damage sekarang: ${sword.damage}")

    println("\nCoba set damage 1500")
    sword.damage = 1500
    println("Damage sekarang: ${sword.damage}")
    println("Tier sekarang: ${sword.tier}")
}
