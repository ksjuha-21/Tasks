package main.commands;

import java.io.File;

/**
 * Created by toshiba_admin on 07.09.2017.
 */
public class PwdCommand implements Command{

    @Override
    public String execute(){
        String result = new File(".").getAbsolutePath();

        return result;

    }
}
