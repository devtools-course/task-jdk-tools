package es.local;

import java.util.concurrent.ThreadLocalRandom;

public class Sangria {
    public static int hi() {
        return ThreadLocalRandom.current().nextInt();
    }
}
