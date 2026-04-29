package oop_00000077278_HotasiRogateManurung_week10

fun main() {
    println("\n=== TEST GENERIC CLASS ===")
    val intBox = Box(100)
    val stringBox = Box("Generics in kotlin")

    println("\n=== TEST GENERIC FUNCTION ===")
    printData(3.14)
    val result = processData("Stable Coin")
    println("Hasill proses: $result")


    println("Isi intBox: ${intBox.value}")
    println("Isi stringBox: ${stringBox.value}")

    println("\n=== TEST MULTIPLE PARAMETERS ===")
    val itemPrice = PairBox("Bitcoin", 65000)
    println("Aset: ${itemPrice.key}, harga: ${itemPrice.value} USD")

    println("\n=== TEST CONSTRAINTS ===")
    val math = MathBox(10.5, 20)
    println("Total: ${math.sum()}")
    println("Terbesar: ${getMax(45, 90)}")



}