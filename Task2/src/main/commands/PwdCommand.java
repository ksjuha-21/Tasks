package main.commands;

import java.io.File;

/**
 * @author Okcana Severovostokova
 **/
public class PwdCommand implements Command {

    @Override
    public String execute() {
        String result = new File(".").getAbsolutePath();
        return result;
    }
}
