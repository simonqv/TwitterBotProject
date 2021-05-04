import twitter4j.TwitterException;

/**
 * Main class. 
 *
 * @author Sofia Eriksson
 * @author Simon Larspers Qvist
 * @version 2021-05-03
 */

public class Main {
    public static void main(String[] args) throws TwitterException {
        Tweeter t = new Tweeter();
        System.out.println(t.postTweet("totesostot"));
    }
}
