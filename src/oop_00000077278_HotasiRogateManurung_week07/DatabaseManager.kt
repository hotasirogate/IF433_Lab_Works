package oop_00000077278_HotasiRogateManurung_week07

object DatabaseManager {
    var connectionStatus: String = "Disconnected"

    fun connect() {
        connectionStatus = "Connected to Server"
        println("Database is ready.")
    }
}