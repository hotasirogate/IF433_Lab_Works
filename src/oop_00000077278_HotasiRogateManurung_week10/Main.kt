package oop_00000077278_HotasiRogateManurung_week10

fun main() {
    println("=== TEST GENERIC CLASS ===")
    val intBox = Box(100)
    val stringBox = Box("Generics in kotlin")

    println("=== TEST GENERIC FUNCTION ===")
    printData(3.14)
    val result = processData("Stable Coin")
    println("Hasill proses: $result")


    println("Isi intBox: ${intBox.value}")
    println("Isi stringBox: ${stringBox.value}")

    println("\n=== TEST MULTIPLE PARAMETERS ===")
    val itemPrice = PairBox("Bitcoin", 65000)
    println("Aset: ${itemPrice.key}, harga: ${itemPrice.value} USD")


}