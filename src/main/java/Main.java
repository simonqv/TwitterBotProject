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

    public static void main(String[] args) throws TwitterException {
        Tweeter t = new Tweeter();
        //System.out.println(t.postTweet("totesostot"));
        TweetReader tr = new TweetReader();
        List<Status> l = tr.getTimeLine();

        for (var s : l) {
            System.out.println(s.getLang() + ": " + s.getText());
            System.out.println(s.getUser().getName() + " " + s.getText());
        }
        //var s = new Translator().toRovarspraket("Hej jag är hungrig!");
        //var s = new Translator().toPiglatin("Please, shut your mouth and hide your teeth!");
        //System.out.println(s);
        //System.out.println("Easeplay, utshay yourway outhmay andway idehay yourway eethtay!");
    }
}
