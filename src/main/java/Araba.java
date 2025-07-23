
class Araba {
    String detayLink;
    String aciklama;
    String marka;
    String model;
    String km;
    String vites;
    double fiyat;
    String fotoUrl;


    public Araba(String detayLink, String aciklama, double fiyat, String marka, String model, String km, String vites, String fotoUrl) {
        this.detayLink = detayLink;
        this.aciklama = aciklama;
        this.marka = marka;
        this.model = model;
        this.km = km;
        this.vites = vites;
        this.fiyat = fiyat;
        this.fotoUrl = fotoUrl;
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

    public String getFotoUrl() {
        return fotoUrl;
    }


    @Override
    public String toString() {
        return "{\n" +
                "  foto = " + fotoUrl + ",\n" +
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















