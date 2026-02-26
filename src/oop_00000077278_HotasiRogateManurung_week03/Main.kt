package oop_00000077278_HotasiRogateManurung_week03

fun main() {
    val e = Employee("Budi")

    e.salary = -1000
    e.salary = 500000
    println("Gaji: ${e.salary}")

    e.increasePerformance()

    println("Pajak yang harus dibayar: ${e.tax}")
}