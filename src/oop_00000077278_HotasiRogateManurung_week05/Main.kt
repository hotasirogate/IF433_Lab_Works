package oop_00000077278_HotasiRogateManurung_week05

fun main() {

    val eWallet = EWallet("Hotasi Rogate", 50000.0)
    val creditCard = CreditCard("Hotasi Rogate", 100000.0)

    val paymentMethods: List<PaymentMethod> = listOf(eWallet, creditCard)

    for (method in paymentMethods) {

        println("Memproses pembayaran sebesar 75000.0")
        method.processPayment(75000.0)

        // Smart Casting menggunakan is
        if (method is EWallet) {
            println("Terdeteksi EWallet → Melakukan Top Up 50000.0")
            method.topUp(50000.0)

            println("Mencoba pembayaran lagi...")
            method.processPayment(75000.0)
        }

        println("-----------------------------")
    }
}