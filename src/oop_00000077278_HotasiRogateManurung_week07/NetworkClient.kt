package oop_00000077278_HotasiRogateManurung_week07

class NetworkClient private constructor(val url: String) {
    fun connect() {
        println("Connecting to $url...")
    }
}