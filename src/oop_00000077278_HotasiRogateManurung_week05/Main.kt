package oop_00000077278_HotasiRogateManurung_week05

fun main() {
    val mathHelper = MathHelper()

    println("Luas Persegi: " + mathHelper.hitungLuas(4))
    println("Luas Persegi Panjang: " + mathHelper.hitungLuas(5, 3))
    println("Luas Lingkaran: " + mathHelper.hitungLuas(7.0))

    val luasPersegi = mathHelper.hitungLuas(4)
    val luasPersegiPanjang = mathHelper.hitungLuas(6, 3)
    val luasLingkaran = mathHelper.hitungLuas(7.0)

    println("Luas Persegi (sisi = 4) = $luasPersegi")
    println("Luas Persegi Panjang (6 x 3) = $luasPersegiPanjang")
    println("Luas Lingkaran (r = 7.0) = $luasLingkaran")

}