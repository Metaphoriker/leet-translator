package xyz.leet.translator.discord;

import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class DiscordHandler {
    
    private static final DiscordRPC DISCORD_RPC = DiscordRPC.INSTANCE;
    private static final DiscordRichPresence DISCORD_RICH_PRESENCE = new DiscordRichPresence();
    
    static {
        
        DISCORD_RPC.Discord_Initialize("926269769173332029", null, true, null);
        
        DISCORD_RICH_PRESENCE.details = "http://leet-translator.xyz/";
        DISCORD_RICH_PRESENCE.largeImageKey = "leet";
        DISCORD_RICH_PRESENCE.largeImageText = "http://leet-translator.xyz/";
        DISCORD_RICH_PRESENCE.startTimestamp = System.currentTimeMillis();
    
        Thread worker = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                DISCORD_RPC.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
            }
        }, "RPC-Callback-Handler");
        
        worker.setDaemon(true);
        worker.start();
    }
    
    public static void update() {
        DISCORD_RPC.Discord_UpdatePresence(DISCORD_RICH_PRESENCE);
    }
    
    public static void setDetails(String details) {
        
        DISCORD_RICH_PRESENCE.details = details;
        DISCORD_RPC.Discord_UpdatePresence(DISCORD_RICH_PRESENCE);
    }
    
    public static void setState(String state) {
        
        DISCORD_RICH_PRESENCE.state = state;
        DISCORD_RPC.Discord_UpdatePresence(DISCORD_RICH_PRESENCE);
    }
    
}
