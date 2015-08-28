package fr.ilicos.pluginTemplate;

import fr.ilicos.pluginTemplate.commandExecutor.AbstractCommandExecutor;
import fr.ilicos.pluginTemplate.commandExecutor.PluginCommandExecutor;
import fr.ilicos.pluginTemplate.listener.ConnectionDisconnectionListener;
import fr.ilicos.pluginTemplate.utils.Destroyable;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/**
 * Created by ilicos, Théo S. on 07/08/2015.
 */
public class MainManager extends Destroyable {
    private static MainManager instance;
    private PluginTemplate plugin;
    private FileConfiguration fileConfig;

    public static MainManager getInstance() {
        if (instance == null){
            instance = new MainManager();
        }
        return instance;
    }

    private MainManager() {}

    public void init(PluginTemplate plugin){
        this.plugin = plugin;
        setupFilesConfig();
        reloadPrevention();
        setupListeners();
        setupCommandExecutors();
    }

    private void setupFilesConfig(){
        plugin.saveDefaultConfig();
        fileConfig = plugin.getConfig();
        fileConfig.options().copyDefaults(true);
    }

    private void setupCommandExecutors(){
        setCommandExecutor(new PluginCommandExecutor());
    }

    private void setupListeners() {
        addListener(new ConnectionDisconnectionListener());
    }

    private void reloadPrevention() {}

    public FileConfiguration getFileConfig(){
        return fileConfig;
    }

    public void saveConfig(){
        plugin.saveConfig();
    }

    public void addListener (Listener listener){
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }

    public void removeListener (Listener listener){
        HandlerList.unregisterAll(listener);
    }

    public void setCommandExecutor(AbstractCommandExecutor commandExecutor) {
        String commandExecutorLabel = commandExecutor.getLabel();
        PluginCommand pluginCommand = plugin.getCommand(commandExecutorLabel);

        if (pluginCommand == null){
            ConsoleCommandSender console = plugin.getServer().getConsoleSender();
            console.sendMessage("[PluginTemplate] " + ChatColor.RED + "Error, you do not regist command '" + commandExecutorLabel + "' in plugin.yml");
        } else {
            pluginCommand.setExecutor(commandExecutor);
        }
    }

    @Override
    public void destroy() {
        instance = null;
    }
}
