// Cool package (since java 25)
package root;

// Manage ids
public class Snd {
    private static int CNT = 0;

    // internal counter: gives a unique id
    public static int counter() {
        return CNT++;
    }

    // checks whether provided id is correct
    public static boolean isValid(int id) {
        return id >= 0 && id < CNT;
    }
}
