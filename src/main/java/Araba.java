
class Araba {
    String arabaDetayLink;
    String aciklama;
    String marka;
    String model;
    int km;
    String vites;
    int fiyat;



    public Araba(String arabaDetayLink, String aciklama, int km, String vites, String marka, String model, int fiyat) {
        this.arabaDetayLink = arabaDetayLink;
        this.aciklama = aciklama;
        this.marka = marka;
        this.model = model;
        this.km = km;
        this.vites = vites;
        this.fiyat = fiyat;

    }

    public String getArabaDetayLink() {
        return arabaDetayLink;
    }

    public void setArabaDetayLink(String arabaDetayLink) {
        this.arabaDetayLink = arabaDetayLink;
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
//
//    @Override
//    public String toString() {
//        return "{\n" +
//                "  link = " + arabaDetayLink + ",\n" +
//                "  açıklama = " + aciklama + ",\n" +
//                "  marka = '" + marka + "',\n" +
//                "  model = '" + model + "',\n" +
//                "  km = " + km + ",\n" +
//                "  fiyat = " + fiyat + "\n" +
//                "  vites = " + vites + ",\n" +
//                "}";
//
//    }
}















