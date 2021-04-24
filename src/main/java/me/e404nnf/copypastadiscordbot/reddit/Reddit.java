package me.e404nnf.copypastadiscordbot.reddit;

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

import java.util.List;
import java.util.Random;


public class Reddit {

    // Log in to Reddit
    UserAgent userAgent = new UserAgent("bot", "<APP_ID>", "v0.1", "<USERNAME>");
    Credentials credentials = Credentials.script("<USERNAME>", "<PASSWORD>",
            "<CLIENT_ID>", "<CLIENT_SECRET>");
    NetworkAdapter adapter = new OkHttpNetworkAdapter(userAgent);
    RedditClient redditClient = OAuthHelper.automatic(adapter, credentials);

    // Load top 50 posts today
    DefaultPaginator<Submission> paginate = redditClient
            .subreddit("copypasta")
            .posts()
            .limit(50)
            .sorting(SubredditSort.TOP)
            .timePeriod(TimePeriod.DAY)
            .build();

    public List<Listing<Submission>> randomPosts = paginate.accumulate(50);

    // Select a random submission
    Random rand = new Random();
    Listing<Submission> randomPost = randomPosts.get(rand.nextInt(randomPosts.toArray().length));
    public Submission randomSubmission = randomPost.get(1);

}
