package week11_A

fun String.rubah_huruf_depan_jadi_besar():String {
    var hasil = this.split(" ").joinToString(" "){
        it.replaceFirstChar {
            c -> c.uppercase();
        }
    }
    return "Hai $hasil";
}

fun Int.tentukanGrade(namaMhs:String) {
    var hasilGrade = "E";
    if(this>=80) {
        hasilGrade = "A"
    }else if (this>=70) {
        hasilGrade = "B"
    }else {
        hasilGrade = "C"
    }
    println(namaMhs + " Grade kamu " + hasilGrade);
}

fun String?.cekNulldanEmpty():String {
    if(this == null || this.isEmpty()) {
        return "Username ga boleh null atau empty";
    }else {
        return "Username kamu $this";
    }
}

class Mahasiswa {
    var nim:String = ""
    var nama:String = ""
    var nilai:Int = 6
}


fun main() {
    println("Udin sedunia".rubah_huruf_depan_jadi_besar());

    71.tentukanGrade("Eligrah");

    var usernameKamu: String? = null;
    println(usernameKamu.cekNulldanEmpty());

    //SCOOPE - LET
    var kampusKamu: String = "UMN";
    kampusKamu.let {
        println("Nama Kampus Kamu " + it);
        if (it == "UMN") {
            println("Ih Keren");
        } else {
            println("Amazing")
        }
    }


    //SCOOPE - RUN
    var namaMatkul: String = "OOP";
    namaMatkul.run {
        println("Matkul Favorit saya " + this);
    }

    //SCOOPE - WITH
    val keputusanLulus = with(70) {
        if (this >= 70) {
            "Lulus"
        } else {
            "Remedial"
        }
    }
    println("Kamu $keputusanLulus");

    //SCOOPE - APPLY
    val namaMahasiswa = Mahasiswa().apply {
        nim = "12345";
        nama = "Dwiky";
        nilai = 100;
    }

    //SOOPE - ALSO
    val arDeret = mutableListOf<Int>(60, 70, 56, 80);
    arDeret.also {
        println("Deret Sebelum : $arDeret")
    }.add(90)
    println("Deret Setelah : $arDeret")

}