import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;

public class Ozellikler {
    public static void main(String[] args) throws IOException {
        Set<String> kullanilan = new HashSet<>();
        List<Araba> arabalar = new ArrayList<>();

        for (int s = 1; s <= 50; s++) {
            Document doc = Jsoup.connect("https://www.arabam.com/ikinci-el?page=" + s).get();
            Elements arabaLinkleri = doc.select("a.link-overlay");
            for (Element link : arabaLinkleri) {
                String detayLink = "https://www.arabam.com" + link.attr("href");

                if (kullanilan.contains(detayLink)) {
                    continue;
                }
                kullanilan.add(detayLink);

                try {
                    Document detayDoc = Jsoup.connect(detayLink).get();
                    String aciklama = detayDoc.select("div.product-name-container").text();
                    String fiyatStr = detayDoc.select("div.desktop-information-price").text();

                    Element foto = detayDoc.select("img.swiper-main-img").first();
                    String fotoUrl = foto.attr("data-src");

                    Elements ozellikler = detayDoc.select("div.property-item");
                    String model = "Null";
                    String km = "Null";
                    String marka = "Null";
                    String vites = "Null";

                    for (Element ozellik : ozellikler) {
                        String key = ozellik.selectFirst("div.property-key").text();
                        String value = ozellik.selectFirst("div.property-value").text();

                        if (key.contains("Marka")) {
                            marka = value;
                        } else if (key.contains("Model")) {
                            model = value;
                        } else if (key.contains("Kilometre")) {
                            km = value;
                        }else if (key.contains("Vites Tipi")) {
                            vites = value;
                        }
                    }

                    System.out.println("İlan: " + aciklama);
                    System.out.println("Fiyat: " + fiyatStr);
                    System.out.println("Marka: " + marka);
                    System.out.println("Model: " + model);
                    System.out.println("Kilometre: " + km );
                    System.out.println("Vites Türü: " + vites);
                    System.out.println("Fotoğraf: " + fotoUrl);
                    System.out.println("**************************************");
//
//                    Araba yeniAraba = new Araba(detayLink, aciklama, fiyatStr, marka, model, km, vites, fotoUrl);
//                    arabalar.add(yeniAraba);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}