package fr.ilicos.pluginTemplate.commandExecutor.commandModels;

import fr.ilicos.pluginTemplate.config.ArgType;
import org.bukkit.command.CommandSender;

/**
 * Created by ilicos, Théo S. on 14/08/2015.
 */
public abstract class CommandModel {
    private final String commandLabel;
    private final boolean needPlayer;
    private final int argsNumber;
    private final ArgType argType;
    protected String successMessage = "";
    private final String neededPermission;

    public CommandModel(String commandLabel, int argsNumber, ArgType argType, boolean needPlayer, String neededPermission){
        this.commandLabel     = commandLabel;
        this.argsNumber       = argsNumber;
        this.argType          = argType;
        this.needPlayer       = needPlayer;
        this.neededPermission = neededPermission;
    }

    public CommandModel(String commandLabel, int argsNumber, ArgType argType, boolean needPlayer){
        this(commandLabel, argsNumber, argType, needPlayer, null);
    }

    public CommandModel(String commandLabel, boolean needPlayer){
        this(commandLabel, 0, ArgType.NULL, needPlayer, null);
    }

    public boolean needPlayer(){
        return needPlayer;
    }

    public boolean isValidArgs(String args[], CommandSender commandSender){
        if (argsNumber == args.length){
            if (argType.validArg(args)){
                return true;
            } else {
                commandSender.sendMessage("Error: Command needs " + argType.name().toLowerCase() + " type");
            }
        } else {
            commandSender.sendMessage("Error: Command needs " + argsNumber + " argument(s)!");
        }

        return false;
    }

    public String getCommandLabel() {
        return commandLabel;
    }

    public int getArgsNumber() {
        return argsNumber;
    }

    public void executeCommand(String[] args, CommandSender commandSender){
        commandSender.sendMessage(successMessage);
    }

    public String getNeededPermission() {
        return neededPermission;
    }
}
