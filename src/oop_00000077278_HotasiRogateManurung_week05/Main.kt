import oop_00000077278_HotasiRogateManurung_week05.EWallet

fun main() {
    val ewallet = EWallet("Hotasi Rogate", 100000.0)

    ewallet.processPayment(50000.0)
    ewallet.processPayment(60000.0)

    ewallet.topUp(20000.0)
    ewallet.processPayment(60000.0)

    val creditCard = CreditCard("Hotasi Rogate", 5000000.0)

    creditCard.processPayment(2000000.0)
    creditCard.processPayment(2500000.0)
    creditCard.processPayment(1000000.0) // Ini akan ditolak
}
}