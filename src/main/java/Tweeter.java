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

        for (TranslatedStatus translated : ts) {
            StringBuilder sb = parser(translated);

            if (!translated.getStatus().getUser().getName().equals("bandolero")) {
                if (sb.length() < 280) {
                    twitter.updateStatus(sb.toString());
                    // System.out.println(sb.toString());
                } else {
                    List<String> subTweetList = tweetSplitter(sb);
                    long inReplyToStatusId = -1;

                    for (String sub : subTweetList) {
                        // System.out.println(sub);
                        StatusUpdate statusUpdate = new StatusUpdate(sub);
                        statusUpdate.setInReplyToStatusId(inReplyToStatusId);
                        Status updatedStatus = twitter.updateStatus(statusUpdate);
                        inReplyToStatusId = updatedStatus.getId();
                    }
                }
            }
        }
    }

    // Status first, Translated second
    private StringBuilder parser(TranslatedStatus translatedStatus) {
        StringBuilder sb = new StringBuilder();
        var tra = translatedStatus.getStatus().getUser().getName();
        System.out.println(tra);
        sb.append("@/")
                .append(translatedStatus.getStatus().getUser().getName());

        if (translatedStatus.getStatus().getLang().equals("en")) {
            sb.append(" eetedtway:");
        } else {
            sb.append(" totwoweetotadode:");
        }
        sb.append("\n")
                .append(translatedStatus.getTranslatedTweet());
        return sb;
    }

    private List<String> tweetSplitter(StringBuilder sb) {
        // Start values
        int min = 0;
        int max = 276; // make room for counter, eg. (1), (2), and so on
        int counter = 1;
        List<String> subTweetList = new ArrayList<>();

        while (min < sb.length()) {
            if (sb.length() - min < 276) {
                subTweetList.add("(" + counter + ") " + sb.substring(min, sb.length() - 1));
                min = max;
                max += 276;
                counter++;
            } else {
                if (!String.valueOf(sb.charAt(max)).equals(" ")) {
                    max--;
                } else {
                    subTweetList.add("(" + counter + ") " + sb.substring(min, max));
                    min = max;
                    max += 276;
                    counter++;
                }
            }
        }
        return subTweetList;
    }
}
