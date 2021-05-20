import twitter4j.*;
/**
 * This class is responsible for reading the tweets on the timeline
 *
 * @author Sofia Eriksson
 * @author Simon Larspers Qvist
 * @version 2021-05-20
 */

public class TweetReader {

    public TweetReader(){
        Twitter twitter = new TwitterFactory().getInstance();
    }

    /**
     * Read the tweets on the timeline
     * @return a list of these tweets
     * @throws TwitterException in case of any twitter error
     */
    public ResponseList<Status> getTimeLine() throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();

        return twitter.getHomeTimeline(new Paging());
    }

}
