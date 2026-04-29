package week10_A

class meja(val hasil:Any)

class kursi<T>(val hasil:T)

class Televisi<T, V>(val merk:T, val kodeBarcode:V)

fun <T> Alamat(kodepos:T):T {
    return kodepos
}

class kalkulator<T: Number>(val a:T, val b:T) {
    fun tambah():Int {
        return a.toInt() + b.toInt();
    }
    fun kurang(): Double {
        return a.toDouble() - b.toDouble();
    }
}

fun main() {
    println("======= Generic kalkulator ========");
    val kal = kalkulator(a = 10.5, b = 28.43);
    println("Hasil tambahan " + kal.tambah());
    println("Hasil pengurangan " + kal.kurang())

    println("======= implementasi Non-Generic ========");
    val mj = meja(hasil = 100)
    val hargaMeja = mj.hasil as Int
    println(hargaMeja + 50)

    println("======= implementasi Generic ========");
    val chair = kursi(hasil = 300);
    println(chair.hasil + 50);

    println("======= Generic multi Param ========");
    val tv = Televisi(merk = "Samsung", kodeBarcode = 88477);
    println("Merknya " + tv.merk);
    println("Barcode ${tv.kodeBarcode + 777}");

    println("======= Generic Function ========");
    println("Kode pos kamu: " + Alamat(kodepos = 154133))

}