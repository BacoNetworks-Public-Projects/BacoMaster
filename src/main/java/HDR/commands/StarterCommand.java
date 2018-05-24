package HDR.commands;


import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import static HDR.config.StarterStrings.*;

public class StarterCommand implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        PaginationList.builder()
                .title(Text.of(TextStyles.BOLD, TextColors.GREEN, "BacoNetworks Kit Selector"))
                .contents(TinkersKitString, SurvivorKitString, AeKitString, ThermalKitString)
                .padding(Text.of("="))
                .sendTo(src);

        return CommandResult.success();
    }
}
