package oop_00000077278_HotasiRogateManurung_week08

class City(val name: String)
class Address(val city: City?)
class DeliveryDetails(val address: Address?)
class Order(val details: DeliveryDetails?, val totalPrice: Int?)