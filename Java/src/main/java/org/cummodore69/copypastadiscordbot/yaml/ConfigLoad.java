package org.cummodore69.copypastadiscordbot.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class ConfigLoad {

    public Config config;
    public String prefix;
    public String command;
    public String token;

    public String appId;
    public String version;
    public String username;
    public String password;
    public String clientId;
    public String clientSecret;
    public String subreddit;

    public ConfigLoad() throws IOException {

        File file = new File("src/main/resources/config.yml");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        config = mapper.readValue(file, Config.class);

        prefix = config.getPrefix();
        command = config.getCommand();
        token = config.getDiscordToken();

        appId = config.getReddit().getAppId();
        version = config.getReddit().getVersion();
        username = config.getReddit().getUsername();
        password = config.getReddit().getPassword();
        clientId = config.getReddit().getClientId();
        clientSecret = config.getReddit().getClientSecret();
        subreddit = config.getReddit().getSubreddit();

    }

}
