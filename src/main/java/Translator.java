import twitter4j.Status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Translator class.
 *
 * @author Sofia Eriksson
 * @author Simon Larspers Qvist
 * @version 2021-05-11
 */
public class Translator {
    private final List<Status> status;

    public Translator(List<Status> status) {
        this.status = status;
    }

    public List<TranslatedStatus> translate() throws Exception {
        List<TranslatedStatus> statusList = new ArrayList<>();
        for (var s : status) {
            try {
                String lang = s.getLang();
                int len = s.getText().length();
                switch (lang) {
                    case "en":
                        statusList.add(new TranslatedStatus(s, toPiglatin(s.getText())));

                        break;
                    case "sv":
                        statusList.add(new TranslatedStatus(s, toRovarspraket(s.getText())));

                        break;
                    case "da":
                        statusList.add(new TranslatedStatus(s, toRovarspraket("Danska är ändå nästan svenska " + s.getText())));

                        break;
                    default:
                        //
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

        }
        return statusList;
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

        for (String s : list) {
            // Word starts with vowel
            if (s.matches("^[aieouyAIEOUY].*")) {
                sb.append(s).append("way");

                // Word starts with consonant
            } else if (s.matches("^[qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM].*")) {
                // Split word into characters
                List<String> charList = Arrays.asList(s.split("(?!^)"));

                // Count how many capital letters in the beginning of the word
                int j = 0;
                while (j < charList.size() &&
                        charList.get(j).matches("^[qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM]")) {
                    j++;
                }

                // Both the first and last character are capital letters
                // (most likely a word with only capital letters)
                if (charList.get(0).matches("[A-Z]") &&
                        charList.get(charList.size()-1).matches("[A-Z]")) {
                    sb.append(charList.get(j).toUpperCase())
                            .append(s.substring(j + 1))
                            .append(s.substring(0, j))
                            .append("AY");

                // Both the first and last character are not capital letters
                // (most likely a word with no capital letters)
                } else if (charList.get(0).matches("[a-z]") &&
                        charList.get(charList.size()-1).matches("[a-z]")){
                    sb.append(s.substring(j))
                            .append(s.substring(0, j))
                            .append("ay");

                // The first character is a capital letter
                // (Most likely a word that starts with a capital letter, all others are lower case)
                } else if (charList.get(0).matches("[A-Z]") &&
                        charList.get(charList.size()-1).matches("[a-z]")){
                    sb.append(charList.get(j).toUpperCase())
                            .append(s.substring(j+1))
                            .append(s.substring(0, j).toLowerCase())
                            .append("ay");

                    // The last character is a capital letter
                    // (Most likely a very strange word)
                } else {
                    sb.append(s.substring(j).toLowerCase())
                            .append(s.substring(0, j))
                            .append("AY");
                }

                // Word is actually whitespace or punctuation
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
