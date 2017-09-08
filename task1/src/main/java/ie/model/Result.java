package ie.model;

/**
 * @author Okcana Severovostokova
 **/
public class Result {

    private String result = "";
    private static Result instance;

    private Result() {
        instance = null;
    }

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
