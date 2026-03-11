package oop_00000077278_HotasiRogateManurung_week06

class Smartphone : Camera, Phone {
    override fun turnOn() {
        super<Camera>.turnOn()
        super<Phone>.turnOn()
    }
}