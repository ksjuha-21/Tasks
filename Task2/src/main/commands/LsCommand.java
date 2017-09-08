package main.commands;

import java.io.File;
/**
 * @author Okcana Severovostokova
 **/
public class LsCommand implements Command {
    @Override
    public String execute() {

        String result = "";
        File file;
        try {
            file = new File("..\\Task2\\src\\main\\commands");
            File[] paths = file.listFiles();
            for (File path : paths) {
                result = result + path.getName() + "<br/>";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
