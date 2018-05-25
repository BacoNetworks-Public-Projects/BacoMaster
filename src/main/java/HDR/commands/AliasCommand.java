package HDR.commands;

import com.google.common.collect.Maps;
import org.spongepowered.api.Sponge;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AliasCommand {

    private String alias;

    private String permission;

    private List<String> commands;

    public AliasCommand(String alias, String permission, List<String> commands) {
        this.alias = alias;
        this.permission = permission;
        this.commands = commands;
    }

    public List<String> getCommands() {
        return this.commands;
    }

    public String getPermission() {
        return this.permission;
    }

    public Map<String, String> mapToCommand(String command) throws IllegalArgumentException {
        Map<String, String> argumentMap = Maps.newHashMap();

        String[] inputArgs = command.split(" ");
        String[] aliasArgs = alias.split(" ");

        if (inputArgs.length != aliasArgs.length) {
            throw new IllegalArgumentException("Wrong command format. Use " + alias);
        }

        for (int i = 1; i < inputArgs.length; i++) {
            argumentMap.put(aliasArgs[i], inputArgs[i]);
        }

        return argumentMap;
    }
}
