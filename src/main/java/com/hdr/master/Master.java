package com.hdr.master;

import cofh.skins.CapeHandler;
import cofh.skins.SkinHandler;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.WorldCoord;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class Master extends JavaPlugin implements Listener {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Master(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){


        String bmprefix = ChatColor.BLACK + "" + ChatColor.BOLD + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BacoMaster" + ChatColor.BLACK + ChatColor.BOLD + "] " + ChatColor.RESET;
        if (cmd.getName().equalsIgnoreCase("bm")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.AQUA + "-----------------------------");
                sender.sendMessage(ChatColor.DARK_RED + "BacoMaster 1.5.2 Version " + getDescription().getVersion());
                sender.sendMessage(ChatColor.AQUA + "-----------------------------");
            } else {
                if (args[0].equalsIgnoreCase("gettown")) {
                    Player getplayer = getServer().getPlayer(args[1]);
                    try {
                     if (getplayer.hasPlayedBefore()) {
                        try {
                            if (WorldCoord.parseWorldCoord(getplayer).getTownBlock().hasTown()) {
                                String townString = WorldCoord.parseWorldCoord(getplayer).getTownBlock().getCoord().toString();
                                sender.sendMessage(bmprefix + ChatColor.GOLD + getplayer.getName() + "'s Town is located at " + townString);
                            } if (!WorldCoord.parseWorldCoord(getplayer).getTownBlock().hasTown()) {
                                sender.sendMessage(bmprefix +"The player named " + args[1] + " could not be found, or does not belong to a town." );
                            }
                        } catch (Exception ignored){sender.sendMessage(bmprefix +"The player named " + args[1] + " could not be found, or does not belong to a town." );}
                     }
                    } catch (ArrayIndexOutOfBoundsException ignored) {sender.sendMessage(bmprefix +"The player named " + args[1] + " could not be found, or does not belong to a town." );}
                } else {
                    if (args[0].equalsIgnoreCase("fixskin")) {
                        SkinHandler.sendRemovePacket(sender.getName());
                        SkinHandler.registerSkin(sender.getName(), "http://minecraft.tools/download-skin/" + sender.getName(), true);
                        sender.sendMessage(bmprefix + "Your Skin has been fixed.");
                        SkinHandler.sendAddPacket(sender.getName());
                    } else {
                        if (args[0].equalsIgnoreCase("staffcape")) {
                            CapeHandler.sendRemovePacket(sender.getName());
                            CapeHandler.registerCape(sender.getName(), "https://i.imgur.com/4lhqGxf.png", true);
                            sender.sendMessage(bmprefix + "Staff cape has been applied");
                            CapeHandler.sendAddPacket(sender.getName());
                        } else {
                            if(args[0].equalsIgnoreCase("ctp")){
                                try {
                                    Player player = (Player) sender;
                                    Location tpPoint = new Location(getServer().getWorld(args[1]), Integer.parseInt(args[2]) * 16, 100, Integer.parseInt(args[3]) * 16);
                                    player.teleport(tpPoint);
                                } catch (Exception ignored) {sender.sendMessage(bmprefix + "Please use numbers.");}
                            } else {
                                if (args[0].equalsIgnoreCase("listworlds")) {
                                    int i = 0;
                                    for(World w : getServer().getWorlds()) {
                                        sender.sendMessage(i  +". " + w.toString().replace("CraftWorld{name=", "").replace("}", ""));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (!e.getPlayer().hasPlayedBefore()) {
            SkinHandler.registerSkin(e.getPlayer().getName(), "http://minecraft.tools/download-skin/" + e.getPlayer().getName(), true);
            SkinHandler.sendAddPacket(e.getPlayer().getName());
        }
    }
}
