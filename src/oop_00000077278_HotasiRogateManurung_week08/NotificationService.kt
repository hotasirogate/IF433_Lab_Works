package oop_00000077278_HotasiRogateManurung_week08

class NotificationService {
    fun sendEmail(emailAddress: String) {
        println("Mengirim email ke: $emailAddress")
    }

    fun processUser(user: UserProfile) {

        if (user.email != null) {
            sendEmail("User ${user.name} tidak memiliki email.")
        } else {
            println("User ${user.name} tidak memiliki email.")
        }
    }
}