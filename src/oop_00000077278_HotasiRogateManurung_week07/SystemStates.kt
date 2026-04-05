package oop_00000077278_HotasiRogateManurung_week07

import java.util.concurrent.ThreadPoolExecutor

enum class AppState {
    STARTING, RUNNING, STOPPED
}

sealed class ApiResponse {
    data class Success(val data: String) : ApiResponse()
    data class Error(val message: String) : ApiResponse()
    object Loading : ApiResponse()
}