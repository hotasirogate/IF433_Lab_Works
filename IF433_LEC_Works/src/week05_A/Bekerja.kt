package week05_A

interface Bekerja {
    public val namaKerjaan:String;
    val gaji: Int;
    val jmlHari:Int;
    val GajiDidapat:Int
            get() = gaji * jmlHari;
    public fun ngoding();
    public fun tester() {
        println("nge test codingan")
    }

}