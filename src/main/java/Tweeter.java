import twitter4j.*;

import java.util.ArrayList;
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

    public void postTweet(List<TranslatedStatus> ts) throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();
        StringBuilder sb = parser(ts);

<<<<<<< HEAD
        if (!ts.get(0).getStatus().getUser().toString().equals("bandole19183971")) {
            if (sb.length() > 280) {
                twitter.updateStatus(sb.toString());
            } else {
                List<String> subTweetList = tweetSplitter(sb);
                long inReplyToStatusId = -1;
                int counter = 0;
=======
        // Vad vill vi göra?
        // steg 1: Vi vill ta in tweetet
        // vad behöver vi?
            // * själva tweeten. user. (eventually vill vi typ ha positiv eller negativ?? eller bild)



        // steg 2: vi vill kolla hur långt det är

        // steg 2.5: dela upp om det är för lpngt

        // steg 3: tweeta
>>>>>>> 40ec95c0d0b1f5ab8f9df883ab8044d880f34ed7

                while (!subTweetList.isEmpty()) {
                    StatusUpdate statusUpdate = new StatusUpdate(Integer.toString(counter));
                    statusUpdate.setInReplyToStatusId(inReplyToStatusId);

                    Status updatedStatus = twitter.updateStatus(statusUpdate);
                    inReplyToStatusId = updatedStatus.getId();
                    counter++;
                }
            }
        }
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

    private List<String> tweetSplitter(StringBuilder sb) {
        int min = 0;
        int max = 280;
        List<String> subTweetList = new ArrayList<>();
        while (max < sb.length()) {
            if (sb.length() - min - 1 < 280) {
                subTweetList.add(sb.substring(min, sb.length() - 1));
            } else {
                if (String.valueOf(sb.charAt(max)).equals(" ")) {
                    max--;
                } else {
                    subTweetList.add(sb.substring(min, max));
                    min = max;
                    max += 280;
                }
            }
        }
        return subTweetList;
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
