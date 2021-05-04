import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TweetReader {
    String tweet;

    public TweetReader(){
        Twitter twitter = new TwitterFactory().getInstance();




    }

    public String getTweet() {
        return tweet;
    }
}
