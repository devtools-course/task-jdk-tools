package deps.inner;

public class Head {
    public static String choose(int n) {
        if (n > 100 || n < 0) {
            throw new IllegalArgumentException("What is it?");
        }

        if (n >= 40) {
            return "Smirnoff";
        }

        return "Gancia";
    }
}
