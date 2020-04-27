/**
 * This program tells you about situation in the world from your terminal
 * It's not really useful, but I need practice :)
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Indicate the source
        Document doc = Jsoup.connect("https://www.worldometers.info/coronavirus/")
                        .userAgent("Chrome/4.0.249.0 Safari/532.5")
                        .referrer("http://www.google.com")
                        .get();

        // Scrap data from site
        Element worldSicStat = doc.select(".maincounter-number span").get(0);
        Element worldDeathStat = doc.select(".maincounter-number span").get(1);
        Element worldRecoveredStat = doc.select(".maincounter-number span").get(2);

        // Output of data
        System.out.println("World coronavirus cases: " + worldSicStat.text());
        System.out.println("World deaths: " + worldDeathStat.text());
        System.out.println("World recovered: " + worldRecoveredStat.text());
    }
}
