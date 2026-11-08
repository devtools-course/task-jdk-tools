package deps;

import deps.inner.Head;

public class Proxy {
    void main() {
        IO.println("Hello World");
    }

    public static void serve(int... requests) {
        for (int i = 0; i < requests.length; i += 2) {
            var result = Head.choose(requests[i]);
            IO.println(result);
        }
    }
}
