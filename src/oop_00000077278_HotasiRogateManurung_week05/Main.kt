package oop_00000077278_HotasiRogateManurung_week05

fun main() {

    // Buat objek EWallet dan CreditCard
    val eWallet = EWallet("Hotasi Rogate", 50000.0)
    val creditCard = CreditCard("Hotasi Rogate", 100000.0)

    // Masukkan ke dalam list bertipe PaymentMethod
    val paymentMethods: List<PaymentMethod> = listOf(eWallet, creditCard)

    // Lakukan perulangan dan panggil processPayment
    for (method in paymentMethods) {
        println("Memproses pembayaran menggunakan ${method.accountName}")
        method.processPayment(75000.0)
        println("-----------------------------")
    }
}