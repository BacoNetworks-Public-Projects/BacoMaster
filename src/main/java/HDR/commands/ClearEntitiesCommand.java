package HDR.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import static HDR.config.BacoMasterStrings.BacoMasterBracketTwo;
import static HDR.config.BacoMasterStrings.BacoMasterBracketone;
import static HDR.config.BacoMasterStrings.BacoMasterString;


public class ClearEntitiesCommand implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        int Distance = 20;
        Player player = (Player) src;
        for(Entity entity : player.getNearbyEntities(Distance)) {
            entity.remove();
        }
        player.sendMessage(Text.of(BacoMasterBracketone, BacoMasterString, BacoMasterBracketTwo, "Removed all entities in a ", Distance, " block radius."));
        return CommandResult.success();
    }
}
