import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.util.List;
import java.util.stream.Collectors;

public class TweetReader {

    public TweetReader(){
        Twitter twitter = new TwitterFactory().getInstance();
    }
    public ResponseList<Status> getTimeLine() throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();

        return twitter.getHomeTimeline(new Paging());
    }

}
