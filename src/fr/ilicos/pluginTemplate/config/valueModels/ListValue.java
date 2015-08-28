package fr.ilicos.pluginTemplate.config.valueModels;

import fr.ilicos.pluginTemplate.MainManager;
import fr.ilicos.pluginTemplate.commandExecutor.commandModels.CommandConfigModel;

/**
 * Created by ilicos, Théo S. on 28/08/2015.
 */
public class ListValue extends ConfigValue {
    protected ListValue(String label, CommandConfigModel commandModel) {
        super(label, commandModel);
    }

    @Override
    public Object getValue() {
        return MainManager.getInstance().getFileConfig().getList(label);
    }
}
