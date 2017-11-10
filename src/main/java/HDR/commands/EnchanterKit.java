package HDR.commands;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;

public class EnchanterKit implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player) {
            Player player = (Player) src;
            Sponge.getCommandManager().process(player, "kit enchantstarter");
            Sponge.getCommandManager().process(Sponge.getServer().getConsole(), "lp user " + player.getName() + " promote player");
            Sponge.getCommandManager().process(Sponge.getServer().getConsole(), "econ add " + player.getName() + " 1000");
            Sponge.getCommandManager().process(Sponge.getServer().getConsole(), "warp " + player.getName() + " started");

        }
        return CommandResult.success();
    }
}