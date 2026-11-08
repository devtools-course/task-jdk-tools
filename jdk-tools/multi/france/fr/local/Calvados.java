package fr.local;

import java.util.concurrent.ThreadLocalRandom;

public class Calvados {
    public static int hi() {
        return ThreadLocalRandom.current().nextInt();
    }
}
