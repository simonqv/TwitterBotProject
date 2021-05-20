import twitter4j.Status;

/**
 * Just to save the translated tweets together with the original one and its information.
 *
 * @author Sofia Eriksson
 * @author Simon Larspers Qvist
 * @version 2021-05-20
 */
public class TranslatedStatus {
    private final Status status;
    private final String translatedTweet;

    public TranslatedStatus(Status status, String translatedTweet) {
        this.status = status;
        this.translatedTweet = translatedTweet;
    }

    public Status getStatus() {
        return status;
    }

    public String getTranslatedTweet() {
        return translatedTweet;
    }
}
