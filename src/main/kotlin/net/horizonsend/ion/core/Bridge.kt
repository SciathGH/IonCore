package net.horizonsend.ion.core

import org.bukkit.entity.Player

interface Bridge {
	val isIonPresent: Boolean

	fun getLevelEquivalentForPlayer(player: Player): Int

	fun getRanktrackRankDisplayName(player: Player): String

	fun getRanktrackDisplayName(player: Player): String
}

class DummyBridge: Bridge {
	override val isIonPresent: Boolean = false
	override fun getLevelEquivalentForPlayer(player: Player): Int = 100

	override fun getRanktrackRankDisplayName(player: Player): String = "Refugee"

	override fun getRanktrackDisplayName(player: Player): String = "REFUGEE"
}

var bridge: Bridge = DummyBridge()