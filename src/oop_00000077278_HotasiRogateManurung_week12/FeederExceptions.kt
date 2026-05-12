package oop_00000077278_HotasiRogateManurung_week12

// Parent Exception
sealed class FeederException(msg: String) : Exception(msg)

// Child Exceptions
class InvalidFoodException :
    FeederException("Makanan yang diberikan tidak valid")

class OverfeedException :
    FeederException("Hewan sudah terlalu kenyang")