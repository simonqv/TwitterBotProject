import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Tweeter {

    public String postTweet(String tweet) throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();
        Status status = twitter.updateStatus(tweet);
        return status.getText();
    }
}
