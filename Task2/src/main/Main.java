package main;

import main.commands.Command;


public class Main {

    public static void main(String[] args) {

        try {
            String action = String.valueOf(args[0]);

            Command command = GetCommand.getInstance().getCommand(action);
            String result = command.execute();
            System.out.println(result);

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
