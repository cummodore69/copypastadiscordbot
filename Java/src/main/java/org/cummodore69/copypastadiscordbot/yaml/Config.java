package org.cummodore69.copypastadiscordbot.yaml;

public class Config {

    private String prefix;
    private String command;
    private String discordToken;
    private ConfigReddit reddit;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDiscordToken() {
        return discordToken;
    }

    public void setDiscordToken(String discordToken) {
        this.discordToken = discordToken;
    }

    public ConfigReddit getReddit(){
        return reddit;
    }

    public void setReddit(ConfigReddit reddit){
        this.reddit = reddit;
    }


}
