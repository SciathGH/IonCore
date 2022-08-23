package net.horizonsend.ion.server.listeners.bukkit

import net.horizonsend.ion.core.events.PlayerPickupAluminiumEvent
import net.horizonsend.ion.core.events.PlayerPickupChetheriteEvent
import net.horizonsend.ion.core.events.PlayerPickupTitaniumEvent
import net.horizonsend.ion.core.events.PlayerPickupUraniumEvent
import net.starlegacy.feature.misc.CustomItems
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerAttemptPickupItemEvent

@Suppress("unused")
class PlayerPickUpItemListener : Listener {
	@EventHandler(priority = EventPriority.MONITOR)
	fun onPlayerPickUpItem(event: PlayerAttemptPickupItemEvent){
		if (event.item == CustomItems.MINERAL_TITANIUM.singleItem()){
			PlayerPickupTitaniumEvent(event.player)
		}
		if (event.item == CustomItems.MINERAL_ALUMINUM.singleItem()){
			PlayerPickupAluminiumEvent(event.player)
		}
		if (event.item == CustomItems.MINERAL_CHETHERITE.singleItem()){
			PlayerPickupChetheriteEvent(event.player)
		}
		if (event.item == CustomItems.MINERAL_URANIUM.singleItem()){
			PlayerPickupUraniumEvent(event.player)
		}
	}
}