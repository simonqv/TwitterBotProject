import twitter4j.Status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Rövarspråket
 * Pig Latin
 */
public class Translator {
    private List<Status> statusList;
    private Status status;
    private String translatedTweet;

    public Translator(List<Status> statusList) {
        this.statusList = statusList;
    }

    public Translator(Status status, String translatedTweet) {
        this.status = status;
        this.translatedTweet = translatedTweet;

    }

    public List<String> translate(List<Status> status) throws Exception {
        List<String> translatedTweet = new ArrayList<>();

        for (var s : status) {
            try {
                String lang = s.getLang();
                int len = s.getText().length();
                switch (lang) {
                    case "en":
                        translatedTweet.add(toPiglatin(s.getText()));
                        new Translator(s, toPiglatin( s.getText()));

                        break;
                    case "sv":
                        translatedTweet.add(toRovarspraket(s.getText()));

                        break;
                    case "da":
                        translatedTweet.add("Danska är ändå nästan svenska " + toRovarspraket(s.getText()));

                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

        }
        return translatedTweet;
    }

    /**
     * Method to translate into rövarspråket.
     * @param tweet the tweet to translate
     * @return translated string
     */
    public String toRovarspraket(String tweet) {

        List<String> list = Arrays.asList(tweet.split("(?!^)"));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).matches("^[qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM]$")) {
                list.set(i, list.get(i) + "o" + list.get(i).toLowerCase());
            }
        }
        for (String string : list) {
            sb.append(string);
        }

        return sb.toString();

    }

    /**
     * Method to translate into pig latin.
     * @param tweet the tweet to translate
     * @return translated string
     */
    public String toPiglatin(String tweet) {

        // Split into words, whitespace and punctuation
        List<String> list = Arrays.asList(tweet.split("\\b"));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
                // Word starts with vowel
            if (list.get(i).matches("^[aieouyAIEOUY].*")) {
                sb.append(list.get(i) + "way");

                // Word starts with consonant
            } else if (list.get(i).matches("^[qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM].*")) {
                List<String> charList = Arrays.asList(list.get(i).split("(?!^)"));
                int j = 0;
                while (charList.get(j).matches("^[qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM]")) {
                    j++;
                }
                if (charList.get(0).matches("[A-Z]")) {
                    sb.append(charList.get(j).toUpperCase()
                            + list.get(i).substring(j+1)
                            + list.get(i).substring(0,j).toLowerCase()
                            + "ay");
                } else {
                    sb.append(list.get(i).substring(j)
                            + list.get(i).substring(0,j)
                            + "ay");
                }

                // Word is actually whitespace or punctuation
            } else {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
}
