package fr;

import java.util.concurrent.ThreadLocalRandom;

public class Grapes {
    public static int grow() {
        return ThreadLocalRandom.current().nextInt();
    }
}
