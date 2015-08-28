package fr.ilicos.pluginTemplate.commandExecutor.commands;

import fr.ilicos.pluginTemplate.commandExecutor.commandModels.CommandModel;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Created by ilicos, Théo S. on 28/08/2015.
 */
public class CommandSuperJump extends CommandModel {
    public CommandSuperJump() {
        super("superJump", true);
    }

    @Override
    public void executeCommand(String[] args, CommandSender commandSender) {
        super.executeCommand(args, commandSender);
        Player player = (Player)commandSender;
        player.setVelocity(new Vector(0,100,0));
    }
}
