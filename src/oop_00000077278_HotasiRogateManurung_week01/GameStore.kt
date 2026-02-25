package oop_00000077278_HotasiRogateManurung_week01

fun main() {
    val gameTitle: String = "Elden Ring"
    val price: Int = 750_000

    val discount: Int = calculateDiscount(price = price)
    val finalPrice: Int = calculateFinalPrice(
        price = price,
        discount = discount
    )

    printResult(
        title = gameTitle,
        originalPrice = price,
        finalPrice = finalPrice
    )
}

fun calculateDiscount(price: Int): Int =
    if (price > 500_000)
        (price * 0.20).toInt()
    else
        (price * 0.10).toInt()

fun calculateFinalPrice(price: Int, discount: Int): Int =
    price - discount

fun printResult(title: String, originalPrice: Int, finalPrice: Int) {
    println("Judul Game   : $title")
    println("Harga Asli   : Rp $originalPrice")
    println("Harga Akhir  : Rp $finalPrice")
}