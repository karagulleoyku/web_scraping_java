import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;

public class Ozellikler {
    public static void main(String[] args) throws IOException {
        Set<String> kullanilan =new HashSet<>();
        for (int s=1;s<=50;s++) {
            Document doc = Jsoup.connect("https://www.arabam.com/ikinci-el?page=" + s).get();
            Elements arabaLinkleri = doc.select("a.link-overlay");
            for (Element link : arabaLinkleri)  {
                String detayLink = "https://www.arabam.com" + link.attr("href");

                if (kullanilan.contains(detayLink)) {
                    continue;
                }
                kullanilan.add(detayLink);

                try {
                    Document detayDoc = Jsoup.connect(detayLink).get();
                    String aciklama = detayDoc.select("div.product-name-container").text();
                    String fiyat = detayDoc.select("div.desktop-information-price").text();
                    Element foto = detayDoc.select("img.swiper-main-img").first();
                    String fotoUrl= foto.attr("data-src");

                    System.out.println("İlan: " + aciklama);
                    System.out.println("Fiyat: " + fiyat);
                    System.out.println("Fotoğraf: " + fotoUrl);
                    System.out.println("**************************************");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}