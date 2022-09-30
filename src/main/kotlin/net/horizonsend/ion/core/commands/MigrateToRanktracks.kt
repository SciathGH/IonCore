package net.horizonsend.ion.core.commands

import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Default
import kotlin.math.floor
import kotlin.math.max
import net.horizonsend.ion.core.events.RanktrackMigrateEvent
import net.horizonsend.ion.core.feedback.FeedbackType
import net.horizonsend.ion.core.feedback.sendFeedbackMessage
import net.starlegacy.cache.nations.PlayerCache
import net.starlegacy.command.SLCommand
import net.starlegacy.database.schema.misc.SLPlayer
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@CommandAlias("ranktrackmigrate")
@Suppress("unused")
object MigrateToRanktracks : SLCommand() {
	@Default
	@CommandPermission("ion.core.xp.migrate")
	fun onRanktrackMigrate(sender: CommandSender){
		val playerCache = PlayerCache[(sender as? Player)!!]
		val slPlayer: SLPlayer = SLPlayer[playerCache.id] ?: return
		if (slPlayer.hasMigrated){
			sender.sendFeedbackMessage(FeedbackType.USER_ERROR, "Error: Cant migrate twice")
		}
		val totalXp = (50*(slPlayer.level)* max(1.0, floor(slPlayer.level/50.0)) +50)
		RanktrackMigrateEvent(sender, totalXp.toInt()).callEvent()
		slPlayer.hasMigrated = true
	}
}