package oop_00000077278_HotasiRogateManurung_week02

import java.util.Scanner

fun main() {

    val scanner = Scanner(System.`in`)

    println("--- LIBRARY FINE SYSTEM ---")

    print("Masukkan Judul Buku: ")
    val title = scanner.nextLine()

    print("Masukkan Nama Peminjam: ")
    val borrower = scanner.nextLine()

    print("Masukkan Durasi Pinjam (hari): ")
    val duration = scanner.nextInt()

    val loan = Loan(title, borrower, duration)

    println("\n--- HASIL ---")
    println("Total Denda: Rp ${loan.calculateFine()}")
}
