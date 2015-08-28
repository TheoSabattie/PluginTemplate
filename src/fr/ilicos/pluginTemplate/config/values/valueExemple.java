package fr.ilicos.pluginTemplate.config.values;

import fr.ilicos.pluginTemplate.commandExecutor.commandModels.CommandConfigModel;
import fr.ilicos.pluginTemplate.config.ArgType;
import fr.ilicos.pluginTemplate.config.valueModels.IntValue;

/**
 * Created by ilicos, Théo S. on 28/08/2015.
 */
public class valueExemple extends IntValue {
    public valueExemple() {
        super("valueExemple", new CommandConfigModel("setValueExemple", 1, ArgType.INT, false));
        commandModel.setConfigValue(this);
    }
}
