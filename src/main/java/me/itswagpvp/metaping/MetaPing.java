package me.itswagpvp.metaping;

import me.itswagpvp.metaping.commands.Ping;
import me.itswagpvp.metaping.listener.TabCompleteHandler;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public final class MetaPing extends Plugin {

    private static MetaPing plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Ping());
        getProxy().getPluginManager().registerListener(this, new TabCompleteHandler());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MetaPing getInstance() {
        return plugin;
    }

}
