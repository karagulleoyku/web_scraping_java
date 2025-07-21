
class Araba {
    String detayLink;
    String aciklama;
    String marka;
    String model;
    int km;
    String vites;
    int fiyat;
    String fotoUrl;


    public Araba(String detayLink, String aciklama, int km) {
        this.detayLink = detayLink;
        this.aciklama = aciklama;
        this.marka = marka;
        this.model = model;
        this.km = km;
        this.vites = vites;
        this.fiyat = fiyat;
        this.fotoUrl = fotoUrl;

    }

    public Araba(String detayLink, String aciklama, String fiyatStr, String marka, String model, String km, String vites, String fotoUrl) {
    }

    public String getArabaDetayLink() {
        return detayLink;
    }

    public void setArabaDetayLink(String arabaDetayLink) {
        this.detayLink = arabaDetayLink;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getVites() {
        return vites;
    }

    public void setVites(String vites) {
        this.vites = vites;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
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
                "}";

    }
}















