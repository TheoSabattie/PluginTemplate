package fr.ilicos.pluginTemplate.commandExecutor;

import fr.ilicos.pluginTemplate.commandExecutor.commandModels.CommandModel;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ilicos, Théo S. on 08/08/2015.
 */
public abstract class AbstractCommandExecutor implements CommandExecutor {
    protected AbstractCommandExecutor(){}
    protected final Map<String, CommandModel> commands = new HashMap<>();

    protected void addCommand(CommandModel command){
        commands.put(command.getCommandLabel(), command);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        boolean isPlayer        = commandSender instanceof Player;
        boolean showListCommand = false;

        if (args.length > 0) {
            String commandLabel = args[0];
            CommandModel commandModel = commands.get(commandLabel);

            if (commandModel != null) {

                if (commandModel.needPlayer() && !isPlayer) {
                    commandSender.sendMessage(ChatColor.RED + "ERROR, command can be perform by player only");
                    showConsoleListCommand(commandSender);
                    return false;
                }

                boolean executeCommand = true;
                args = Arrays.copyOfRange(args, 1, args.length);
                String neededPermission = commandModel.getNeededPermission();

                if (isPlayer && neededPermission != null) {
                    Player player = (Player)commandSender;

                    if (!player.hasPermission(neededPermission) && !player.isOp()){
                        player.sendMessage(ChatColor.RED + "You have not the permission to perform this command!");
                        executeCommand = false;
                    }
                }

                if (executeCommand){
                    if (commandModel.isValidArgs(args, commandSender)) {
                        commandModel.executeCommand(args, commandSender);
                        return true;
                    }
                }

            } else {
                commandSender.sendMessage(ChatColor.RED + "ERROR, " + commandLabel + "does not exist as command");
                showListCommand = true;
            }
        } else {
            showListCommand = true;
        }

        if (showListCommand){
            if (isPlayer) {
                showPlayerListCommand(commandSender);
            } else {
                showConsoleListCommand(commandSender);
            }
        }

        return false;
    }

    protected void showConsoleListCommand(CommandSender commandSender){
        commandSender.sendMessage("list of commands:");
        final String commandLabel = getLabel() + " ";
        String message;
        int argNumber;

        for (CommandModel command : commands.values()){
            message   = (command.needPlayer())? ChatColor.RED.toString() : ChatColor.GREEN.toString();
            message  += commandLabel + command.getCommandLabel();
            argNumber = command.getArgsNumber();

            if (argNumber > 0) {
                message += " {"+argNumber+"arg(s)}";
            }

            commandSender.sendMessage(message);
        }
    }

    /**
     * Commandes prefix
     * @return the first arg of the command
     */
    public abstract String getLabel();

    protected void showPlayerListCommand(CommandSender commandSender){
        commandSender.sendMessage("list of commands:");
        final String commandLabel = "/" + getLabel() + " ";
        String message;
        int argNumber;

        for (CommandModel command : commands.values()){
            message   = commandLabel + command.getCommandLabel();
            argNumber = command.getArgsNumber();

            if (argNumber > 0) {
                message += " {"+argNumber+"arg(s)}";
            }

            commandSender.sendMessage(message);
        }
    }
}
