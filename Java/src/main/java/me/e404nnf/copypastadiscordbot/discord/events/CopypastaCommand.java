package me.e404nnf.copypastadiscordbot.discord.events;

import me.e404nnf.copypastadiscordbot.reddit.Reddit;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Date;

public class CopypastaCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        Reddit reddit = new Reddit();

        Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();

        if (msg.getContentRaw().equals("cp!copypasta")) {

            EmbedBuilder eb = new EmbedBuilder();

            eb.setTitle("r/copypasta");
            eb.setColor(Color.red);
            eb.setDescription("Getting a submission...");

            String selfText = reddit.randomSubmission.getSelfText();
            String title = reddit.randomSubmission.getTitle();
            String url = reddit.randomSubmission.getUrl();
            String author = reddit.randomSubmission.getAuthor();
            Date date = reddit.randomSubmission.getCreated();

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
