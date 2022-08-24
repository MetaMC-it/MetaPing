package me.itswagpvp.metaping.listener;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.TabCompleteEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.stream.Collectors;

public class TabCompleteHandler implements Listener  {
    @EventHandler
    public void onTabComplete(TabCompleteEvent e) {
        if (e.getCursor().contains("ping")) {

            e.getSuggestions().addAll(ProxyServer.getInstance().getPlayers()
                    .stream()
                    .map(ProxiedPlayer::getName)
                    .collect(Collectors.toList()));
        }
    }
}
