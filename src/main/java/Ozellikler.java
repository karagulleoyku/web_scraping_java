import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;

public class Ozellikler {
    public static List<Araba> arabaIlanları() throws IOException {
        Set<String> kullanilan = new HashSet<>();
        List<Araba> arabalar = new ArrayList<>();

        for (int s = 1; s <=2; s++) {
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

                    List<String> fotoUrlList = new ArrayList<>();

                    Elements foto = detayDoc.select("img.swiper-main-img");

                    if (foto.isEmpty()) {
                        fotoUrlList.add("Fotoğraf Bulunamadı");
                    } else {
                        for (Element fotoElement : foto) {
                            String url = fotoElement.attr("data-src");
                            if (url != null && !url.trim().isEmpty()) {
                                fotoUrlList.add(url);
                            }
                        }
                    }
                    Elements ozellikler = detayDoc.select("div.property-item");
                    String model = null;
                    String km = null;
                    String marka = null;
                    String vites = null;

                    for (Element ozellik : ozellikler) {
                        String key = ozellik.selectFirst("div.property-key").text();
                        String value = ozellik.selectFirst("div.property-value").text();

                        if (key.contains("Marka")) {
                            marka = value;
                        } else if (key.contains("Model")) {
                            model = value;
                        } else if (key.contains("Kilometre")) {
                            km = value;
                        } else if (key.contains("Vites Tipi")) {
                            vites = value;
                        }
                    }

                    marka = (marka != null) ? marka : "Marka Belirtilmemiş";
                    model = (model != null) ? model : "Model Belirtilmemiş";
                    km = (km != null) ? km : "KM Belirtilmemiş";
                    vites = (vites != null) ? vites : "Vites Tipi Belirtilmemiş";
                    fiyatStr = (fiyatStr != null) ? fiyatStr : "Fiyat Belirtilmemiş.";
                    aciklama = (aciklama != null) ? aciklama : "Açıklama Belirtilmemiş";

//                    System.out.println("İlan: " + aciklama);
//                    System.out.println("Fiyat: " + fiyat);
//                    System.out.println("Marka: " + marka);
//                    System.out.println("Model: " + model);
//                    System.out.println("Kilometre: " + km );
//                    System.out.println("Vites Türü: " + vites);
//                    System.out.println("Fotoğraf: " + fotoUrlList);
//                    System.out.println("**************************************");

                    Araba yeniAraba = new Araba(detayLink, aciklama, fiyatStr, marka, model, km, vites, fotoUrlList);
                    arabalar.add(yeniAraba);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }catch (Exception e) {
                    System.err.println(detayLink + " işlenirken beklenmedik bir hata oluştu: " + e.getMessage());
                }
            }
        }
        return arabalar;
    }
}