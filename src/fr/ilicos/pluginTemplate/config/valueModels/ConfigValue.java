package fr.ilicos.pluginTemplate.config.valueModels;

import fr.ilicos.pluginTemplate.MainManager;
import fr.ilicos.pluginTemplate.commandExecutor.commandModels.CommandConfigModel;
import org.bukkit.command.CommandSender;

/**
 * Created by ilicos, Théo S. on 28/08/2015.
 */
public abstract class ConfigValue {
    protected final CommandConfigModel commandModel;
    protected final String label;

    protected ConfigValue(String label, CommandConfigModel commandModel){
        this.commandModel = commandModel;
        this.label        = label;
    }

    public CommandConfigModel getCommandModel(){
        return commandModel;
    }

    public boolean onArgs(String[] args, CommandSender commandSender){
        setValue(args[0]);
        return true;
    }

    protected void setValue(Object object){
        MainManager mainManager = MainManager.getInstance();
        mainManager.getFileConfig().set(label, object);
        mainManager.saveConfig();
    }

    public Object getValue(){
        return MainManager.getInstance().getFileConfig().get(label);
    }

    public boolean isValid(){
        return getValue() != null;
    }

    public String getLabel() {
        return label;
    }
}
