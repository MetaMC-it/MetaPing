package me.itswagpvp.metaping.velocity;

import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.command.CommandMeta;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import me.itswagpvp.metaping.velocity.commands.Ping;

import javax.inject.Inject;
import java.util.logging.Logger;

@Plugin(id = "metaping", name = "MetaPing", version = "1.0", authors = {"_ItsWagPvP"})
public class MetaPingVelocity {
    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public MetaPingVelocity(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;

        logger.info("Loading MetaPing");
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        CommandManager cm = server.getCommandManager();
        CommandMeta commandMeta = cm.metaBuilder("ping")
                .aliases("metaping")
                .plugin(this)
                .build();

        SimpleCommand ping = new Ping(server);

        // register the command
        cm.register(commandMeta, ping);
    }

}
