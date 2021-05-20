import twitter4j.Status;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;
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
        for (int i = 0; i < 14; i++) {
            try {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime timeNow = LocalTime.now();
                String formattedTime = timeNow.format(format);
                if (formattedTime.equals("09:00") || formattedTime.equals("15:00")) {
                    TweetReader tr = new TweetReader();
                    List<Status> l = tr.getTimeLine();                  // get tweets
                    Translator translator = new Translator(l);
                    List<TranslatedStatus> ts = translator.translate(); // translate tweets
                    Tweeter t = new Tweeter(ts);
                    t.postTweet();                                    // Post tweet
                    Thread.sleep(60000);
                } else {
                    i--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
