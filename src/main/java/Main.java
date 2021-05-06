import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

/**
 * Main class. 
 *
 * @author Sofia Eriksson
 * @author Simon Larspers Qvist
 * @version 2021-05-03
 */

public class Main {

    //test
    
    public static void main(String[] args) throws TwitterException {
        Tweeter t = new Tweeter();
        //System.out.println(t.postTweet("totesostot"));
        // Har lite problem med git...
        TweetReader tr = new TweetReader();
        List<Status> l = tr.getTimeLine();
        for (var s : l) {
            System.out.println(s.getUser().getName() + " " + s.getText());
        }
    }
}
