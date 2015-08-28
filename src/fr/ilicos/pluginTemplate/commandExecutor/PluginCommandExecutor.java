package fr.ilicos.pluginTemplate.commandExecutor;

import fr.ilicos.pluginTemplate.commandExecutor.commands.CommandSuperJump;
import fr.ilicos.pluginTemplate.config.Config;
import org.bukkit.Bukkit;

/**
 * Created by ilicos, Théo S. on 07/08/2015.
 */
public class PluginCommandExecutor extends AbstractCommandExecutor {
    private static final String LABEL = "plTemp";

    public PluginCommandExecutor(){
        for (Config config : Config.values()){
            addCommand(config.getCommandModel());
        }

        addCommand(new CommandSuperJump());
    }

    @Override
    public String getLabel() {
        return LABEL;
    }
}
