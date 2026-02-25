package oop_00000077278_HotasiRogateManurung_week02

class Student (
    val name: String,
    val nim: String,
    var major: String
) {
    init {
        if (nim.length != 5) {
            println("WARNING: objek tercipta dengan NIM ($nim) yang tidak valid!")
            println("Data mahasiswa $name mungkin akan bermasalah di sistem.")
        }
    }
}