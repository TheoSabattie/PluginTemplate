package fr.ilicos.pluginTemplate.config.valueModels;

import fr.ilicos.pluginTemplate.MainManager;
import fr.ilicos.pluginTemplate.commandExecutor.commandModels.CommandConfigModel;
import org.bukkit.command.CommandSender;

/**
 * Created by ilicos, Théo S. on 28/08/2015.
 */
public abstract class IntValue extends ConfigValue {
    protected IntValue(String label, CommandConfigModel commandModel) {
        super(label, commandModel);
    }

    @Override
    public boolean onArgs(String[] args, CommandSender commandSender) {
        setValue(Integer.parseInt(args[0]));
        return true;
    }

    @Override
    public Object getValue() {
        return MainManager.getInstance().getFileConfig().getInt(label);
    }
}
