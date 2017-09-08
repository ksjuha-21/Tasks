package main.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Okcana Severovostokova
 **/
public class PsCommand implements Command {
    @Override
    public String execute() {

        String result = "";

        try {
            Process proc = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            Iterator<String> itr = getSortedList(br).iterator();
            while (itr.hasNext()) {
                result = result + itr.next() + "<br/>" + "\n" + "\r";
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return result;
    }

    private List getSortedList(BufferedReader br) {
        String line;
        List<String> list = new ArrayList<String>();
        try {
            while ((line = br.readLine()) != null) {
                list.add(line);
                //result = result + line + "\n" + "\r";
            }
            br.close();

            Collections.sort(list, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    return o1.compareToIgnoreCase(o2);
                }
            });

        } catch (Throwable t) {
            t.printStackTrace();
        }
        return list;
    }
}
