import gen.Plugin;

import java.lang.management.ManagementFactory;

static final long JVM_START = ManagementFactory.getRuntimeMXBean().getStartTime();

static long uptime() {
    return System.currentTimeMillis() - JVM_START;
}

static int bootstrap(int plugins) throws Exception {
    var out = 0;

    for (int i = 0; i < plugins; i++) {
        var plugin = (Plugin) Class
                .forName("gen.Plugin" + i)
                .getDeclaredConstructor()
                .newInstance();
        out += plugin.run();
    }

    return out;
}

void main(String[] args) throws Exception {
    int plugins = args.length > 2 ? Integer.parseInt(args[0]) : 1500;

    System.err.println(uptime());
    int x = bootstrap(plugins);
    System.err.println(uptime());

    IO.println(x); // Blackhole
}
