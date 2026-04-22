package oop_00000077278_HotasiRogateManurung_week09

fun main() {
    println("=== TEST LAMBDA ===")

    val sumLambda = { a: Int, b: Int -> a + b }
    println("Hasil Sum: ${sumLambda(5, 10)}")

    val squareImplicts: (Int) -> Int = { it * it }
    println("Hasil Square: ${squareImplicts(4)}")
}