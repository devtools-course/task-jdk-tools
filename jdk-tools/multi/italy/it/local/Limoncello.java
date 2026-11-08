package it.local;

import java.util.concurrent.ThreadLocalRandom;

public class Limoncello {
    public static int hi() {
        return ThreadLocalRandom.current().nextInt();
    }
}
