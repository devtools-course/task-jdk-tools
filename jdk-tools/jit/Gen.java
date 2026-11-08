void main(String[] args) throws Exception {
    Path dir = Path.of("gen");
    Files.createDirectories(dir);
    Files.writeString(
            dir.resolve("Plugin.java"),
            """
            package gen;
            public interface Plugin {
                int run();
            }
            """
    );
    for (int i = 0; i < Integer.parseInt(args[0]); i++) {
        String src = """
                package gen;
                import java.util.*;
                import java.util.function.*;
                import java.util.stream.*;
                public class Plugin%1$d implements Plugin {
                    record Item(String name, int v) {}
                    public int run() {
                        Function<Integer, Item> f = x -> new Item("n" + x, x * %1$d);
                        Supplier<List<Item>> s = () -> Stream.of(1, 2, 3).map(f).collect(Collectors.toList());
                        return s.get().stream().mapToInt(Item::v).sum() + "id-%1$d".length();
                    }
                }
                """.formatted(i);
        Files.writeString(dir.resolve("Plugin" + i + ".java"), src);
    }
}
