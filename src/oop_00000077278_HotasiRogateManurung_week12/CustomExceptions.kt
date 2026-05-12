package oop_00000077278_HotasiRogateManurung_week12

class InsufficientFundsException(
    val amount: Double,
    val balance: Double
) : Exception("Attempted $amount, balance $balance")

class BankAccount(var balance: Double) {

    fun withdraw(amount: Double) {

        // cek amount harus positif
        if (amount <= 0) {
            throw IllegalArgumentException("Amount must be positive")
        }

        // cek saldo cukup atau tidak
        if (amount > balance) {
            throw InsufficientFundsException(amount, balance)
        }

        // proses penarikan
        balance -= amount
        println("Withdrawal successful. Remaining balance: $balance")
    }
}