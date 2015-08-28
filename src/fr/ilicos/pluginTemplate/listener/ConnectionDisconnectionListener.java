package fr.ilicos.pluginTemplate.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by ilicos, Théo S. on 08/08/2015.
 */
public class ConnectionDisconnectionListener implements Listener {
    @EventHandler
    public void onPlayerConnection(PlayerJoinEvent event){
        event.setJoinMessage(ChatColor.BLUE + "[PluginTemplate]" + ChatColor.GRAY +" Welcome to " + event.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerDisconnection(PlayerQuitEvent event){
        event.setQuitMessage(ChatColor.BLUE + "[PluginTemplate]" + ChatColor.GRAY + " Byebye to " + event.getPlayer().getName());
    }
}
