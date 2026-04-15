package IF433_LEC_Works_week08

class Alamat(val nomor:String, val kota:String)
class Mahasiswa(val nama:String, val addr: Alamat?)

fun main() {
    val alm = Alamat(nomor = "47", kota = "Tangerang");
    val mhs = Mahasiswa(nama = "Wirawan", addr = alm);

    val defKota = mhs.addr?.let {
        alamatDefault->"Tinggal di ${mhs.addr.kota} nomor ${mhs.addr.nomor}"
    }?:"Tidak tau tinggal dimana.";


    println("hai ${mhs.nama} kamu tinggal di ${defKota}");
}