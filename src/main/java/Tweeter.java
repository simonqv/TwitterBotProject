import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible of posting tweets on the twitter feed, using the translators translated tweets.
 */
public class Tweeter {
    private final List<TranslatedStatus> ts;

    public Tweeter(List<TranslatedStatus> ts) {
        this.ts = ts;
    }

    public void postTweet() throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();
<<<<<<< HEAD
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
=======
>>>>>>> ea05455d0ebc72554022a22499472379226eba3b

        for (TranslatedStatus translated : ts) {
            StringBuilder sb = parser(translated);

<<<<<<< HEAD
        // steg 3: tweeta
>>>>>>> 40ec95c0d0b1f5ab8f9df883ab8044d880f34ed7

                while (!subTweetList.isEmpty()) {
                    StatusUpdate statusUpdate = new StatusUpdate(Integer.toString(counter));
                    statusUpdate.setInReplyToStatusId(inReplyToStatusId);

                    Status updatedStatus = twitter.updateStatus(statusUpdate);
                    inReplyToStatusId = updatedStatus.getId();
                    counter++;
=======
            if (!translated.getStatus().getUser().toString().equals("bandole19183971")) {
                if (sb.length() < 280) {
                    twitter.updateStatus(sb.toString());
                } else {
                    List<String> subTweetList = tweetSplitter(sb);
                    long inReplyToStatusId = -1;

                    for (String sub : subTweetList) {
                        StatusUpdate statusUpdate = new StatusUpdate(sub);
                        statusUpdate.setInReplyToStatusId(inReplyToStatusId);
                        Status updatedStatus = twitter.updateStatus(statusUpdate);
                        inReplyToStatusId = updatedStatus.getId();
                    }
>>>>>>> ea05455d0ebc72554022a22499472379226eba3b
                }
            }
        }
    }


    // Status first, Translated second
    private StringBuilder parser(TranslatedStatus translatedStatus) {
        StringBuilder sb = new StringBuilder();
        var tra = translatedStatus.getStatus().getUser().getName();
        System.out.println(tra);
        sb.append(translatedStatus.getStatus().getUser().getName());

        if (translatedStatus.getStatus().getLang().equals("en")) {
            sb.append(" eetedtway: ");
        } else {
            sb.append(" totwoweetotadode: ");
        }
        sb.append(translatedStatus.getTranslatedTweet());
        return sb;
    }

    private List<String> tweetSplitter(StringBuilder sb) {
        // Start values
        int min = 0;
        int max = 280;
        List<String> subTweetList = new ArrayList<>();
        while (max < sb.length()) {
            if (sb.length() - min < 280) {
                 subTweetList.add(sb.substring(min, sb.length() - 1));
            } else {

                if (!String.valueOf(sb.charAt(max)).equals(" ")) {
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
}
