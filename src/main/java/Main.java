import twitter4j.Status;

import java.util.List;

/**
 * Main class. 
 *
 * @author Sofia Eriksson
 * @author Simon Larspers Qvist
 * @version 2021-05-03
 */

public class Main {

    public static void main(String[] args) {
        try {
            TweetReader tr = new TweetReader();
            // twitter4j.conf.ConfigurationBuilder().TweetModeExtended(true);
            List<Status> l = tr.getTimeLine();                  // get tweets
            Translator translator = new Translator(l);
            List<TranslatedStatus> ts = translator.translate(); // translate tweets
            Tweeter t = new Tweeter(ts);
            t.postTweet();                                    // Post tweet

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
