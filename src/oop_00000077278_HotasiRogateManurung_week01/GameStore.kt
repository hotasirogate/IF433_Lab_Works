package oop_00000077278_HotasiRogateManurung_week01

fun main() {
    val gameTitle: String = "Elden Ring"
    val price: Int = 750_000

    val finalPrice = calculateFinalPrice(price = price)

    printResult(
        title = gameTitle,
        originalPrice = price,
        finalPrice = finalPrice
    )
}

fun calculateFinalPrice(price: Int): Int {
    val discountRate = if (price > 500_000) 0.20 else 0.10
    return (price * (1 - discountRate)).toInt()
}

fun printResult(title: String, originalPrice: Int, finalPrice: Int) {
    println("Judul Game   : $title")
    println("Harga Asli   : Rp $originalPrice")
    println("Harga Akhir  : Rp $finalPrice")
}