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

    public static void main(String[] args) {
        try {
             TweetReader tr = new TweetReader();
             List<Status> l = tr.getTimeLine();                  // get tweets
             Translator translator = new Translator(l);
             List<TranslatedStatus> ts = translator.translate(); // translate tweets
             Tweeter t = new Tweeter(translator);
            // t.postTweet(ts);                      // Post tweet

            String test = "PLATTA";
            String test2 = "PLATTa";
            String test3 = "platta";
            String test4 = "Platta";
            String test5 = "PlaTTa";
            // System.out.println(test.length());
            // System.out.println(test);
            System.out.println(translator.toPiglatin(test));
            System.out.println(translator.toPiglatin(test2));
            System.out.println(translator.toPiglatin(test3));
            System.out.println(translator.toPiglatin(test4));
            System.out.println(translator.toPiglatin(test5));
            //System.out.println(t.postTweet("totesostot"));

            //for (var s : l) {
            //    System.out.println(s.getLang() + ": " + s.getText());
            //    System.out.println(s.getUser().getName() + " " + s.getText());
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
