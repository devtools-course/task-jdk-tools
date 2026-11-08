package fr.run;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;

public class Runner {
    static Class getClass(String className, String packageName) {
        try {
            return Class.forName(
                    packageName + "." + className.substring(0, className.lastIndexOf('.'))
            );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static Stream<String> getClassNames(String packageName) throws IOException {
        URL resource = Objects.requireNonNull(
                ClassLoader
                    .getSystemClassLoader()
                    .getResource(packageName.replace('.', '/'))
        );

        return switch (resource.getProtocol()) {
            case "file" -> Files
                    .list(Path.of(resource.getPath()))
                    .map(p -> p.getFileName().toString());
            case "jar" -> ((JarURLConnection) resource.openConnection())
                    .getJarFile()
                    .stream()
                    .map(ZipEntry::getName)
                    .filter(name -> name.startsWith(packageName.replace('.', '/') + "/"))
                    .filter(name -> !name.substring(packageName.replace('.', '/').length() + 1).contains("/"))
                    .map(name -> name.substring(packageName.replace('.', '/').length() + 1));
            default -> null;
        };
    }

    static void main() throws IOException {
        var pack = "fr.cognac";
        Objects.requireNonNull(getClassNames(pack))
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, pack))
                .map(Class::getName)
                .forEach(System.out::println);
    }
}
