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
 * Runs the program.
 *
 * @author Sofia Eriksson
 * @author Simon Larspers Qvist
 * @version 2021-05-20
 */

public class Main {

    public static void main(String[] args) {
        // Make sure that it tweets 14 times (7 days), given that the program is on for that long.
        for (int i = 0; i < 14; i++) {
            try {
                // To handle date check
                DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime timeNow = LocalTime.now();
                String formattedTime = timeNow.format(format);

                // Only continue if it's 9 am or 3 pm.
                if (formattedTime.equals("09:00") || formattedTime.equals("15:00")) {
                    // Get tweets
                    TweetReader tr = new TweetReader();
                    List<Status> l = tr.getTimeLine();

                    // Translate tweets
                    Translator translator = new Translator(l);
                    List<TranslatedStatus> ts = translator.translate();

                    // Post tweets
                    Tweeter t = new Tweeter(ts);
                    t.postTweet();

                    // Wait for a minute before exiting loop
                    Thread.sleep(60000);

                } else {
                    // if wrong time of day, try again...
                    i--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
