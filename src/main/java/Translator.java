import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Rövarspråket
 * Pig Latin
 */
public class Translator {

    /**
     * Method to translate into rövarspråket.
     * @param tweet the tweet to translate
     * @return translated string builder
     */
    public String rovarspraket(String tweet) {

        List<String> list = Arrays.asList(tweet.split("(?!^)"));

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).matches("^[qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM]$")) {
                list.set(i, list.get(i) + "o" + list.get(i).toLowerCase());
            }
        }

        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string);
        }

/*
        //var newString = tweet.replaceAll("^[eyuioåaöäEYUIOÅÄÖA]$");

        System.out.println(list);


        List<String> rovar = list.stream().map(s -> {
            if (!s.matches("^[eyuioåaöäEYUIOÅÄÖA]$") ) {
                s.replace(s, s + "o" + s);
                System.out.println(s);
            }
            return s;
        }
        ).collect(Collectors.toList());
////   System.out.println(list);
*/
        return sb.toString();
    }

}
