package pl.prutkowski.java.playground.se;

/**
 * Created by programmer on 10/5/16.
 */
public class ExceptionFun {

    public static void main(String[] args) {
        System.out.println(tryWithFinally());
    }

    public static String tryWithFinally() {
        try {
            System.out.println("Throwing new Exception");
            throw new Exception("This is not a bug, this is a feature!");
        } catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
            return "Catched Exception!";
        } finally {
            System.out.println("Finnally block");
            return "Finally";
        }
    }
}
