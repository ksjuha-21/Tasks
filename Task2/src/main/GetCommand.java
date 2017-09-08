package main;

import main.commands.Command;
import main.commands.LsCommand;
import main.commands.PsCommand;
import main.commands.PwdCommand;

import java.util.HashMap;

/**
 * @author Okcana Severovostokova
 **/
public class GetCommand {

    private static GetCommand instance;
    HashMap<String, Command> commands = new HashMap<String, Command>();

    private GetCommand() {

        instance = null;
        commands.put("pwd", new PwdCommand());
        commands.put("ls", new LsCommand());
        commands.put("ps", new PsCommand());
    }

    public Command getCommand(String action) {

        return commands.get(action);

    }

    public static GetCommand getInstance() {
        if (instance == null) {
            instance = new GetCommand();
        }
        return instance;
    }

}
