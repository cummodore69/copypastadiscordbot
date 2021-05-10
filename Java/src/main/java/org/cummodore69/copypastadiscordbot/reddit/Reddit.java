package org.cummodore69.copypastadiscordbot.reddit;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkAdapter;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.models.SubredditSort;
import net.dean.jraw.models.TimePeriod;
import net.dean.jraw.oauth.OAuthHelper;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.pagination.DefaultPaginator;
import org.cummodore69.copypastadiscordbot.yaml.ConfigLoad;

import java.io.IOException;
import java.util.List;
import java.util.Random;


public class Reddit {

    public final List<Listing<Submission>> randomPosts;

    public Submission randomSubmission;

    public Reddit() throws IOException {

        ConfigLoad config = new ConfigLoad();

        // Log in to Reddit
        UserAgent userAgent = new UserAgent("bot", config.appId, config.version, config.username);
        Credentials credentials = Credentials.script(config.username, config.password,
                config.clientId, config.clientSecret);
        NetworkAdapter adapter = new OkHttpNetworkAdapter(userAgent);
        RedditClient redditClient = OAuthHelper.automatic(adapter, credentials);

        // Load top 50 posts today
        DefaultPaginator<Submission> paginate = redditClient
                .subreddit(config.subreddit)
                .posts()
                .limit(50)
                .sorting(SubredditSort.TOP)
                .timePeriod(TimePeriod.DAY)
                .build();

        randomPosts = paginate.accumulate(50);

        // Select a random submission
        Random rand = new Random();
        Listing<Submission> randomPost = randomPosts.get(rand.nextInt(randomPosts.toArray().length));
        randomSubmission = randomPost.get(1);

    }
}
