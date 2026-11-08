// Cool package (since java 25)
package root;

// Dummy notifier
public class Trd {
    // sends message to the next process through stderr
    // msg must be non-null
    public static void message(String msg) {
        if (msg == null) {
            throw new IllegalArgumentException("msg is null");
        }

        System.err.println("MSG: " + msg);
    }
}
