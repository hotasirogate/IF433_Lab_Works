package week12_A

fun basic_trycatch(pembilang:Int, penyebut: Int){
    try {
        val hasil = pembilang/penyebut;
        println("hasil bagi $hasil");
    } catch (e: Exception) {
        println("ada error pembagian ${e.message}");
    } finally {
        println("selesai pembagian");
    }

}

fun cek_tipe_data(angka:String) {
    var nilai: Int = try {
        Integer.parseInt(angka);
    } catch (e: Exception) {
        println("ada error di cek tipe data ${e.message}")
        123
    }
    println("nilai kamu $nilai")

}

fun cek_gaji(hariKerja: Int) {
    if (hariKerja < 0) {
        throw IllegalArgumentException("Masa Hari Kerja Minus");
    } else {
        val gaji = hariKerja * 1000
        println("Gaji Kamu $gaji")
    }
}

fun main() {
    try {
        cek_gaji(-1)
    } catch (e: Exception) {
        println("Error coba catch ::: ${e.message}")
    }

    // Exception - Expression
    cek_tipe_data("10");
}