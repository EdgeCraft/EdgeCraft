package net.edgecraft.edgecore.mod;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.edgecraft.edgecore.EdgeCore;
import net.edgecraft.edgecore.command.AbstractCommand;
import net.edgecraft.edgecore.command.Level;
import net.edgecraft.edgecore.user.User;

public class BroadcastCommand extends AbstractCommand {

	private static final BroadcastCommand instance = new BroadcastCommand();
	
	private BroadcastCommand() { super(); }
	
	public static final BroadcastCommand getInstance() {
		return instance;
	}
	
	@Override
	public String[] getNames() {
		return new String[]{ "broadcast", "say" };
	}

	@Override
	public Level getLevel() {
		return Level.DEVELOPER;
	}

	@Override
	public boolean validArgsRange(String[] args) {
		return args.length > 1;
	}

	@Override
	public void sendUsageImpl(CommandSender sender) {
		sender.sendMessage(EdgeCore.usageColor + "/broadcast <message>");
		sender.sendMessage(EdgeCore.usageColor + "/say <message>");
	}

	@Override
	public boolean runImpl(Player player, User user, String[] args) throws Exception {
		
		return broadcast(player, args);
	}

	@Override
	public boolean sysAccess(CommandSender sender, String[] args) {
		return broadcast(sender, args);
	}

	private boolean broadcast(CommandSender sender, String[] args) {
		
		StringBuilder msg = new StringBuilder();
		
		for(int i = 1; i < args.length; i++) {
			if (msg.length() > 0)
				msg.append(" ");
			
			msg.append(args[i]);
		}
		
		EdgeCore.getChat().broadcast(ChatColor.GREEN + "[Radio Broadcast] " + ChatColor.GOLD + msg.toString() );
		
		return true;
	}
	
}
