package me.itswagpvp.metaping.commands;

import me.itswagpvp.metaping.misc.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Ping extends Command {

    public Ping() {
        super("ping");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof ProxiedPlayer)) {
                sender.sendMessage("§cNon puoi fare questo comando dalla console!");
                return;
            }

            ProxiedPlayer p = (ProxiedPlayer) sender;
            p.sendMessage("§b✈ Ping §7» §fIl tuo ping è di " + Utils.colorizePing(p.getPing()) + "ms§f!");
            return;
        }

        if (args.length == 1) {
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
            if (target == null || !target.isConnected()) {
                sender.sendMessage("§b✈ Ping §7» §cIl giocatore " + args[0] + " non è online!");
                return;
            }

            sender.sendMessage("§b✈ Ping§7 » §fIl ping di §b" + target.getName() + " §fè di " + Utils.colorizePing(target.getPing()) + "ms§f!");
            return;

        }
    }

}
