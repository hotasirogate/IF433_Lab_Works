package oop_00000077278_HotasiRogateManurung_week03

import oop_00000077278_HotasiRogateManurung_week02.Weapon

fun main() {

    val weapon = Weapon("Dragon Blade", 600)

    // Set damage ke -50 (harus gagal)
    weapon.damage = -50

    // Set damage ke 9999 (harus jadi 1000)
    weapon.damage = 9999

    // Print tier
    println("Tier Weapon: ${weapon.tier}")
}
