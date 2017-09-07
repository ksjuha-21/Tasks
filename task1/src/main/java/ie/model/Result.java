package ie.model;

/**
 * Created by toshiba_admin on 11.04.2017.
 */
public class Result {

    private String result = "";
    private static Result instance;

    public static Result getInstance() {
        if (null == instance) {
            instance = new Result();
        }
        return instance;
    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
