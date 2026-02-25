package oop_00000077278_HotasiRogateManurung_week01

fun main() {
    val gameTitle: String = "Elden Ring"
    val price: Int = 750_000

    val discount: Int = calculateDiscount(price = price)
    val finalPrice: Int = price - discount

    printReceipt(
        title = gameTitle,
        finalPrice = finalPrice
    )
}

fun calculateDiscount(price: Int): Int =
    if (price > 500_000)
        (price * 0.20).toInt()
    else
        (price * 0.10).toInt()

fun printReceipt(title: String, finalPrice: Int) {
    println("===== STRUK PEMBELIAN =====")
    println("Judul Game  : $title")
    println("Total Bayar : Rp $finalPrice")
    println("===========================")
}