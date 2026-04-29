package oop_00000077278_HotasiRogateManurung_week10

// Data wrapper untuk response API
data class ApiResponse<T>(
    val status: String,
    val data: T
)
