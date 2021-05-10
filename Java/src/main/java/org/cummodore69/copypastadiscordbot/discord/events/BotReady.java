package org.cummodore69.copypastadiscordbot.discord.events;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

public class BotReady implements EventListener {

    @Override
    public void onEvent(@NotNull GenericEvent genericEvent) {

        if (genericEvent instanceof ReadyEvent){
            System.out.println("The bot is ready!");
        }

    }
}
