import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible of posting tweets on the twitter feed,
 * using the translators translated tweets.
 *
 * @author Sofia Eriksson
 * @author Simon Larspers Qvist
 * @version 2021-05-20
 */
public class Tweeter {
    private final List<TranslatedStatus> ts;

    public Tweeter(List<TranslatedStatus> ts) {
        this.ts = ts;
    }

    /**
     * Posts the list of tweets to our timeline
     * @throws TwitterException if unable to post for some reason (like exceeding maximun tweet length etc.)
     */
    public void postTweet() throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();


        for (TranslatedStatus translated : ts) {
            // Get the StringBuilder to tweet
            StringBuilder sb = parser(translated);

            // As long as its not our tweet go ahead
            if (!translated.getStatus().getUser().getName().equals("bandolero")) {
                // If the tweet is short enough: post
                if (sb.length() < 280) {
                    twitter.updateStatus(sb.toString());
                } else {
                    // Divide into smaller sub-tweets and tweet as a thread
                    List<String> subTweetList = tweetSplitter(sb);
                    long inReplyToStatusId = -1;

                    for (String sub : subTweetList) {
                        StatusUpdate statusUpdate = new StatusUpdate(sub);
                        statusUpdate.setInReplyToStatusId(inReplyToStatusId);
                        Status updatedStatus = twitter.updateStatus(statusUpdate);
                        inReplyToStatusId = updatedStatus.getId();
                    }
                }
            }
        }
    }

    /**
     * Parse the TranslatedStatus and form the tweet we want to tweet
     * @param translatedStatus translation and the corresponding information (like user etc.)
     * @return StringBuilder with the tweet to post
     */
    private StringBuilder parser(TranslatedStatus translatedStatus) {
        StringBuilder sb = new StringBuilder();
        // Add fake at to the user who tweeted original tweet
        sb.append("@/")
                .append(translatedStatus.getStatus().getUser().getName());

        // Depending on langugage add tweeted or twittrade to the start in rövarspåket or pig lating
        if (translatedStatus.getStatus().getLang().equals("en")) {
            sb.append(" eetedtway:");
        } else {
            sb.append(" totwoweetotadode:");
        }
        // Add the translated tweet last
        sb.append("\n")
                .append(translatedStatus.getTranslatedTweet());
        return sb;
    }

    /**
     * Too long tweets needs to be split into smaller chunks
     * @param sb The tweet to split
     * @return A list of divided tweets
     */
    private List<String> tweetSplitter(StringBuilder sb) {
        // Start values
        int min = 0;
        int max = 276; // Make room for the counter in the thread.
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
