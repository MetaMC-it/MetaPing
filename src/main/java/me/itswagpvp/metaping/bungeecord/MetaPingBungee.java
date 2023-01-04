package me.itswagpvp.metaping.bungeecord;

import me.itswagpvp.metaping.bungeecord.commands.Ping;
import me.itswagpvp.metaping.bungeecord.listener.TabCompleteHandler;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public final class MetaPingBungee extends Plugin {

    private static MetaPingBungee plugin;

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

    public static MetaPingBungee getInstance() {
        return plugin;
    }

}
