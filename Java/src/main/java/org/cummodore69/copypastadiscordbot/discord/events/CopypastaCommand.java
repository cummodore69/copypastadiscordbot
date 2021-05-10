package org.cummodore69.copypastadiscordbot.discord.events;

import org.cummodore69.copypastadiscordbot.reddit.Reddit;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.cummodore69.copypastadiscordbot.yaml.ConfigLoad;

import java.awt.*;
import java.io.IOException;
import java.util.Date;

public class CopypastaCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        // Define our config class
        ConfigLoad config = null;

        // Define the reddit class as a variable
        Reddit reddit = null;

        // I swear IntelliJ told me to do this
        try {
            reddit = new Reddit();

            config = new ConfigLoad();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Define the message and it's channel
        Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();

        if (msg.getContentRaw().equals(config.prefix + config.command)) {

            // Create and embed with the title of r/<SUBREDDIT> and color red with description of Getting a submission...
            EmbedBuilder eb = new EmbedBuilder();

            eb.setTitle("r/" + config.subreddit);
            eb.setColor(Color.red);
            eb.setDescription("Getting a submission...");

            // Define the body, title, url, author and date
            String selfText = reddit.randomSubmission.getSelfText();
            String title = reddit.randomSubmission.getTitle();
            String url = reddit.randomSubmission.getUrl();
            String author = reddit.randomSubmission.getAuthor();
            Date date = reddit.randomSubmission.getCreated();

            // Send the embed then edit it with the submission we got
            channel.sendMessage(eb.build())
                    .queue(response -> response.editMessage(eb
                            .setDescription(selfText)
                            .setTitle(title, url)
                            .setAuthor(author)
                            .setFooter(String.valueOf(date))
                            .build())
                            .queue());

        }

    }
}
