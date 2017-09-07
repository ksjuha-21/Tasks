package main;

import main.commands.Command;
import main.commands.LsCommand;
import main.commands.PsCommand;
import main.commands.PwdCommand;

import java.util.HashMap;


public class GetCommand {

    private static GetCommand instance = null;

    HashMap<String, Command> commands = new HashMap<String, Command>();



    private GetCommand() {
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
