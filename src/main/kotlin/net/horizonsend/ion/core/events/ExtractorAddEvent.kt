package net.horizonsend.ion.core.events

import net.starlegacy.util.Vec3i
import org.bukkit.World
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class ExtractorAddEvent(val world: World, val position: Vec3i) : Event() {
	override fun getHandlers() = handlerList

	companion object {
		@JvmStatic
		val handlerList = HandlerList()
	}
}