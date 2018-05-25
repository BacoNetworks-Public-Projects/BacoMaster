package HDR;

import HDR.commands.AliasCommand;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.command.SendCommandEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.game.GameReloadEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static HDR.commands.CommandList.*;

@Plugin(id = "bacomaster", name = "BacoMaster", version = "1.2")
public class BacoMaster {

    @Inject
    @DefaultConfig(sharedRoot = true)
    private Path defaultConfig;

    @Inject
    @DefaultConfig(sharedRoot = true)
    private ConfigurationLoader<CommentedConfigurationNode> configManager;

    private Map<String, AliasCommand> aliases = Maps.newHashMap();

    private void makeCommands() {
        Sponge.getCommandManager().register(this, StarterCMD, "start");
        Sponge.getCommandManager().register(this, BacoMasterCMD, "bacomaster", "bm");
    }

    @Listener
    public void onInit(GameStartedServerEvent e) {
        makeCommands();
        loadAliases();
    }

    @Listener
    public void onServerReload(GameReloadEvent e) {
        makeCommands();
        loadAliases();
    }


    private void loadAliases() {
        aliases.clear();

        try {
            if (!Files.exists(defaultConfig, LinkOption.NOFOLLOW_LINKS)) {
                URL jarConfigFile = this.getClass().getResource("default.conf");
                ConfigurationLoader<CommentedConfigurationNode> loader = HoconConfigurationLoader.builder().setURL(jarConfigFile).build();
                configManager.save(loader.load());
            }

            ConfigurationNode node = configManager.load();

            ConfigurationNode commandsNode = node.getNode("commands");

            for (ConfigurationNode commandNode : commandsNode.getChildrenMap().values()) {
                try {
                    AliasCommand command = new AliasCommand(
                            commandNode.getNode("alias").getString("example {0}"),
                            commandNode.getNode("permission").getString("alias.example"),
                            commandNode.getNode("commands").getList(TypeToken.of(String.class)));

                    aliases.put(commandNode.getNode("alias").getString("example {0}").split(" ")[0], command);
                } catch (ObjectMappingException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Listener
    public void onCommand(SendCommandEvent event, @First CommandSource player) {
        AliasCommand alias = aliases.get(event.getCommand());
        if (alias == null) {
            return; //Not an alias.
        }
        if (!player.hasPermission(alias.getPermission())) {
            player.sendMessage(Text.of(TextColors.RED, "You do not have permission to use this alias!"));
            event.setResult(CommandResult.empty());
            return;
        }

        event.setCancelled(true);

        try {
            Map<String, String> aliasMapping = alias.mapToCommand(event.getCommand() + " " + event.getArguments());

            CommandResult.Builder builder = CommandResult.builder();

            for (String command : alias.getCommands()) {
                command = command.replace("{0}", player.getName());

                Sponge.getGame().getCommandManager().process(Sponge.getServer().getConsole(), command);
            }

            builder.successCount(alias.getCommands().size());

            event.setResult(builder.build());
        } catch(Throwable e) {
            player.sendMessage(Text.of(TextColors.RED, e.getMessage()));
        }
    }
}
