import twitter4j.Status;

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
