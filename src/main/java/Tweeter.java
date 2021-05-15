import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;

public class Tweeter {

    // private final List<Status> statusList;
    private final Translator t;

    public Tweeter(Translator t) {
        //this.statusList = statusList;
        this.t = t;
    }

    public String postTweet(List<TranslatedStatus> ts) throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();

        // Vad vill vi göra?
        // Vi vill ta in tweetet
        // vi vill kolla hur långt det är
        // dela upp om det är för lpngt
        // tweeta


        // var len = statusList.get(1);
        //if ()
        //Status status = twitter.updateStatus(tweet);
        //return status.getText();
            return null;
    }
}
