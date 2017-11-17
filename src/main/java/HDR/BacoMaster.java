package HDR;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

import static HDR.commands.CommandList.*;

@Plugin(id = "bacomaster", name = "BacoMaster", version = "1.1")
public class BacoMaster {

    private void makeCommands() {
        Sponge.getCommandManager().register(this, StarterCMD, "start");
        Sponge.getCommandManager().register(this, BacoMasterCMD, "bacomaster", "bm");
    }

    @Listener
    public void onInit(GameStartedServerEvent e) {
        makeCommands();
    }
}
