package org.moparforia.server;

import org.moparforia.shared.ManifestVersionProvider;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        description = "Starts Minigolf Server",
        name = "server",
        mixinStandardHelpOptions = true,
        versionProvider = ManifestVersionProvider.class,
        subcommands = {
                Converter.class
        }
)
public class Launcher implements Callable<Void> {

    public static final String DEFAULT_HOST = "0.0.0.0";
    public static final int DEFAULT_PORT = 4242;

    @CommandLine.Option(names = {"--hostname", "-ip"},
            description = "Sets server hostname")
    private String host = DEFAULT_HOST;

    @CommandLine.Option(names = {"--port", "-p"},
            description = "Sets server port")
    private int port = DEFAULT_PORT;

    public static void main(String... args) {
        Launcher launcher = new Launcher();
        new CommandLine(launcher)
                .setCaseInsensitiveEnumValuesAllowed(true)
                .execute(args);
    }

    @Override
    public Void call() {
        getServer(host, port).start();
        return null;
    }

    public Server getServer(String host, int port) {
        return new Server(host, port);
    }
}
