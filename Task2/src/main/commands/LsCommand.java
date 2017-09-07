package main.commands;

import java.io.File;


public class LsCommand implements Command {
    @Override
    public String execute() {

        String result = "";
        File f;
        try{
            f = new File("C:\\EDrive\\Task2\\src\\main\\commands");
            File[] paths = f.listFiles();
            for(File path:paths) {
                result = result + path.getName() + "<br/>";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;

    }
}
