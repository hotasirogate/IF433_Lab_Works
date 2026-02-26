package oop_00000077278_HotasiRogateManurung_week02

fun main() {

    println("--- MINI RPG BATTLE ---")

    val hero1 = Hero("Knight", 20)
    val hero2 = Hero("Orc", 15)

    println("${hero1.name} HP: ${hero1.hp}")
    println("${hero2.name} HP: ${hero2.hp}")
    println()

    // Turn 1
    hero1.attack(hero2.name)
    hero2.takeDamage(hero1.baseDamage)

    println("${hero2.name} HP sekarang: ${hero2.hp}")
    println()

    // Turn 2
    hero2.attack(hero1.name)
    hero1.takeDamage(hero2.baseDamage)

    println("${hero1.name} HP sekarang: ${hero1.hp}")
    println()

    // Status akhir
    println("--- STATUS AKHIR ---")
    println("${hero1.name} hidup? ${hero1.isAlive()}")
    println("${hero2.name} hidup? ${hero2.isAlive()}")
}
