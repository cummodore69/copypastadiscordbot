package org.cummodore69.copypastadiscordbot;

import org.cummodore69.copypastadiscordbot.discord.events.BotReady;
import org.cummodore69.copypastadiscordbot.discord.events.CopypastaCommand;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.cummodore69.copypastadiscordbot.yaml.ConfigLoad;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws LoginException, IOException {

        // Define our Config parser class
        ConfigLoad config = new ConfigLoad();

        // Get the token from the Config parser class value
        JDABuilder bot = JDABuilder.createDefault(config.token);

        // Set activity to "Watching Reddit"
        bot.setActivity(Activity.watching("Reddit"));

        // Add the two event Listeners BotReady and CopypastaCommand
        bot.addEventListeners(new BotReady());
        bot.addEventListeners(new CopypastaCommand());

        bot.build();
    }

}
