import java.util.List;

class Araba {
    String detayLink;
    String aciklama;
    String marka;
    String model;
    String km;
    String vites;
    double fiyat;
    List<String> fotoUrls;


    public Araba(String detayLink, String aciklama, String fiyatStr, String marka, String model, String km, String vites, List<String> fotoUrls) {
        this.detayLink = detayLink;
        this.aciklama = aciklama;
        this.marka = marka;
        this.model = model;
        this.km = km;
        this.vites = vites;
        this.fotoUrls = fotoUrls;

        try {
            if (fiyatStr != null && !fiyatStr.trim().isEmpty() && !fiyatStr.equals("0 TL")) {
                this.fiyat = Double.parseDouble(fiyatStr.replaceAll("[^\\d,]", "").replace(",", "."));
            } else {
                this.fiyat = 0.0;
            }
        } catch (NumberFormatException e) {
            this.fiyat = 0.0;
            System.err.println("Uyarı: Fiyat ayrıştırılamadı '" + fiyatStr + "' için " + aciklama + ". 0.0 olarak ayarlanıyor. Hata: " + e.getMessage());

        }
    }

    public String getDetayLink() {
        return detayLink;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public double getFiyat() {
        return fiyat;
    }

    public String getAciklama() {
        return aciklama;
    }

    public String getKm() {
        return km;
    }

    public String getVites() {
        return vites;
    }

    public List<String> getFotoUrls() {
        return fotoUrls;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  fotolar = " + fotoUrls + ",\n" +
                "  açıklama = " + aciklama + ",\n" +
                "  marka = '" + marka + "',\n" +
                "  model = '" + model + "',\n" +
                "  km = " + km + ",\n" +
                "  fiyat = " + fiyat + "\n" +
                "  vites = " + vites + ",\n" +
                "  detay link = " + detayLink + "\n" +
                "}";

    }
}















