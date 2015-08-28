package fr.ilicos.pluginTemplate.config;

import fr.ilicos.pluginTemplate.commandExecutor.commandModels.CommandConfigModel;
import fr.ilicos.pluginTemplate.config.valueModels.ConfigValue;
import fr.ilicos.pluginTemplate.config.values.valueExemple;

/**
 * Created by ilicos, Théo S. on 07/08/2015.
 */
public enum Config{
    EXEMPLE(new valueExemple());

    private final ConfigValue configValue;

    public CommandConfigModel getCommandModel(){
        return configValue.getCommandModel();
    }

    public Object getValue(){
        return configValue.getValue();
    }

    public static boolean isCompleted(){
        for (Config config: values()){
            if (!config.configValue.isValid()){
                return false;
            }
        }
        return true;
    }

    Config(ConfigValue configValue){
        this.configValue = configValue;
    }
}