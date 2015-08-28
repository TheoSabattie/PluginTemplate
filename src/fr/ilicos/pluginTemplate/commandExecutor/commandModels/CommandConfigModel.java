package fr.ilicos.pluginTemplate.commandExecutor.commandModels;

import fr.ilicos.pluginTemplate.config.ArgType;
import fr.ilicos.pluginTemplate.config.valueModels.ConfigValue;
import org.bukkit.command.CommandSender;

/**
 * Created by ilicos, Théo S. on 14/08/2015.
 */
public class CommandConfigModel extends CommandModel {
    private ConfigValue configValue;

    public CommandConfigModel(String commandLabel, int argsNumber, ArgType argType, boolean needPlayer) {
        super(commandLabel, argsNumber, argType, needPlayer);
    }

    @Override
    public void executeCommand(String[] args, CommandSender commandSender) {
        super.executeCommand(args, commandSender);
        configValue.onArgs(args, commandSender);
    }

    public void setConfigValue(ConfigValue configValue) {
        this.configValue = configValue;
        successMessage = "Saving change in " + configValue.getLabel() + " from the command " + getCommandLabel();
    }
}
