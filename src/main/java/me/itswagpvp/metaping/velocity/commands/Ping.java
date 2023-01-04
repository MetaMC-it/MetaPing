package me.itswagpvp.metaping.velocity.commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import me.itswagpvp.metaping.common.Utils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Ping implements SimpleCommand {

    private final ProxyServer server;

    public Ping(ProxyServer server) {
        this.server = server;
    }

    @Override
    public void execute(Invocation invocation) {
        CommandSource source = invocation.source();
        // Get the arguments after the command alias
        String[] args = invocation.arguments();
        if (args.length == 0) {
            if (source instanceof Player) {
                Player player = (Player) source;
                player.sendMessage(Component.text("§b✈ Ping §7» §fIl tuo ping è di " + Utils.colorizePing(((Player) source).getPing()) + "ms§f!"));
            } else {
                source.sendMessage(Component.text("Non puoi fare questo comando dalla console!", NamedTextColor.RED));
            }

            return;
        }

        if (args.length == 1) {
            Player target = server.getPlayer(args[0]).orElse(null);
            if (target == null) {
                source.sendMessage(Component.text("§b✈ Ping §7» §cIl giocatore " + args[0] + " non è online!"));
                return;
            }

            source.sendMessage(Component.text("§b✈ Ping§7 » §fIl ping di §b" + target.getUsername() + " §fè di " + Utils.colorizePing(target.getPing()) + "ms§f!"));
            return;
        }

        source.sendMessage(Component.text("Uso: /ping [player]", NamedTextColor.RED));
        return;

    }

    @Override
    public CompletableFuture<List<String>> suggestAsync(final Invocation invocation) {
        return CompletableFuture.completedFuture(List.of(server.getAllPlayers().stream().map(Player::getUsername).toArray(String[]::new)));
    }

}
