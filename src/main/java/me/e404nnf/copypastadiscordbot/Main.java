package me.e404nnf.copypastadiscordbot;

import me.e404nnf.copypastadiscordbot.discord.events.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException {

        // Yes I'm lazy to make a config or an arg :CoolAstolfo:
        JDABuilder bot = JDABuilder.createDefault("<DISCORD_TOKEN>");

        bot.setActivity(Activity.watching("Reddit"));

        bot.addEventListeners(new BotReady());
        bot.addEventListeners(new CopypastaCommand());

        bot.build();
    }

}
