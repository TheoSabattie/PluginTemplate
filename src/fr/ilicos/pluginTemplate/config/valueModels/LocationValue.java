package fr.ilicos.pluginTemplate.config.valueModels;

import fr.ilicos.pluginTemplate.commandExecutor.commandModels.CommandConfigModel;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by ilicos, Théo S. on 28/08/2015.
 */
public class LocationValue extends ConfigValue {
    protected LocationValue(String label, CommandConfigModel commandModel) {
        super(label, commandModel);
    }

    @Override
    public boolean onArgs(String[] args, CommandSender commandSender) {
        setValue(((Player)commandSender).getLocation());
        return true;
    }
}
