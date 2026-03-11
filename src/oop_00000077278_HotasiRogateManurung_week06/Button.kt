package oop_00000077278_HotasiRogateManurung_week06

class Button (override val name: String) : Clickable {
    override fun click() {
        println("Tombol '$name' berhasil diklik!")
    }
}