package oop_00000077278_HotasiRogateManurung_week05

abstract class PaymentMethod(val accountName: String) {

    // Abstract function (harus dioverride oleh subclass)
    abstract fun processPayment(amount: Double)
}