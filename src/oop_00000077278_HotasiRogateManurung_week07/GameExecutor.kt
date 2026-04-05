package oop_00000077278_HotasiRogateManurung_week07

fun processEvent(event: BattleState) {
    when (event) {

        is BattleState.MonsterEncounter -> {
            println("⚔️ Monster muncul: ${event.monsterName}")
        }

        is BattleState.LootDropped -> {
            // Smart cast langsung bisa akses item
            val item = event.item
            println("🎁 Loot didapat: ${item.name} (Rarity: ${item.rarity}, Drop: ${item.rarity.dropChance}%)")
        }

        is BattleState.GameOver -> {
            println("💀 Game Over! Alasan: ${event.reason}")
        }

        BattleState.SafeZone -> {
            println("🛡️ Kamu berada di Safe Zone. Aman untuk sementara.")
        }
    }
}