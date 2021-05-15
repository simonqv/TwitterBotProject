import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;

/**
 * This class is responsible of posting tweets on the twitter feed, using the translators translated tweets.
 */
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
        // steg 1: Vi vill ta in tweetet
        // vad behöver vi?
        // * själva tweeten. user. (eventually vill vi typ ha positiv eller negativ?? eller bild)



        // steg 2: vi vill kolla hur långt det är

        // steg 2.5: dela upp om det är för lpngt

        // steg 3: tweeta


        // var len = statusList.get(1);
        //if ()
        //Status status = twitter.updateStatus(tweet);
        //return status.getText();
        return null;
    }

    // Status first, Translated second
    private StringBuilder parser(List<TranslatedStatus> ts) {
        Status tweetInfo = ts.get(0).getStatus();
        StringBuilder sb = new StringBuilder();

        sb.append(tweetInfo.getUser().toString());
        if (tweetInfo.getLang().equals("en")) {
            sb.append(" Eetedtway: ");
        } else {
            sb.append(" totwoweetotadode: ");
        }

        return sb.append(ts.get(1).getTranslatedTweet());
    }
}
