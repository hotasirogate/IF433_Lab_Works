package oop_00000077278_HotasiRogateManurung_week07

fun main() {
    println("=== TEST SINGLETON ===")
    println("Status: ${DatabaseManager.connectionStatus}")
    DatabaseManager.connect()

    println("\n=== TEST COMPANION OBJECT ===")
    val client = NetworkClient.createClient()
    client.connect()

    println("\n=== TEST REGULAR CLASS ===")
    val reg1 = RegularUser("Alice", 22)
    val reg2 = RegularUser("Alice", 22)
    println(reg1)
    println("Sama? ${reg1 == reg2}") // False

    println("\n=== TEST DATA CLASS ===")
    val data1 = DataUser("Alice", 22)
    val data2 = DataUser("Alice", 22)
    println(data1)
    println("Sama? ${data1 == data2}") // True

    val data3 = data1.copy(age = 23)
    println("Hasil Copy: $data3")

    val (userName, userAge) = data1
    println("Destructured: $userName berumur $userAge")

    println("\n=== TEST SEALED CLASS ===")
    val response: ApiResponse = ApiResponse.Success("Data berhasil ditarik!")

    val uiMessage = when (response) {
        is ApiResponse.Success -> "Tampilkan: ${response.data}"
        is ApiResponse.Error -> "Munculkan: ${response.message}"
        ApiResponse.Loading -> "Tampilkan Spinner"
    }

    println(uiMessage)

    println("\n=== TEST GAME MANAGER (Singleton) ===")
    GameManager.startGame()

    // FIX: ganti nama variable supaya tidak bentrok
    val rarityItem = ItemRarity.LEGENDARY
    println("Rarity: $rarityItem")
    println("Drop chance: ${rarityItem.dropChance}%")

    val sword = GameItem("Excalibur", 100, ItemRarity.LEGENDARY)

    println(sword)
    println("Nama: ${sword.name}")
    println("Damage: ${sword.damage}")
    println("Rarity: ${sword.rarity}")
    println("Drop Chance: ${sword.rarity.dropChance}%")

    val starter = Weapon.forgeStarterSword()
    val epic = Weapon.forgeEpicSword()

    println("Starter: ${starter.item.name}, Damage: ${starter.item.damage}, Durability: ${starter.durability}")
    println("Epic: ${epic.item.name}, Damage: ${epic.item.damage}, Durability: ${epic.durability}")

    val state: BattleState = BattleState.MonsterEncounter("Goblin")

    val message = when (state) {
        is BattleState.MonsterEncounter -> "Musuh muncul: ${state.monsterName}"
        is BattleState.LootDropped -> "Dapat item: ${state.item.name}"
        is BattleState.GameOver -> "Game Over: ${state.reason}"
        BattleState.SafeZone -> "Kamu berada di zona aman"
    }

    println(message)

    processEvent(BattleState.MonsterEncounter("Goblin"))

    val itemDrop = GameItem("Pedang Api", 50, ItemRarity.RARE)
    processEvent(BattleState.LootDropped(itemDrop))

    processEvent(BattleState.GameOver("Dikalahkan Boss"))
    processEvent(BattleState.SafeZone)
}