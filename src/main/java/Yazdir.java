import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Yazdir {
    List<Araba> arabalar;
    List<String> satisKayitlari;

    public Yazdir(List<Araba> cekilenArabalar) {
        this.arabalar = new ArrayList<>(cekilenArabalar);;
        this.satisKayitlari = new ArrayList<>();
    }

    public void arabaListele() {
        if (arabalar.isEmpty()) {
            System.out.println("Listelenecek araç bulunmamaktadır.");
            return;
        }
        System.out.println("\n=== Mevcut Arabalar ===");
        for (int i = 0; i < arabalar.size(); i++) {
            System.out.println("ID: " + i); // Seçim için ID ekle
            System.out.println(arabalar.get(i));
            System.out.println("--------------------------------------");
        }
    }


    public void satislar() {
        if (satisKayitlari.isEmpty()) {
            System.out.println("Henüz hiç satış kaydedilmedi.");
            return;
        }
        System.out.println("\n=== Satış Kayıtları ===");
        for (String kayit : satisKayitlari) {
            System.out.println(kayit);
        }
    }

    public void fiyataGore(Scanner scanner) {
        System.out.print("Maksimum fiyatı girin: ");
        double maxFiyat ;
        try {
            maxFiyat = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Geçersiz giriş. Lütfen fiyat için sayısal bir değer girin.");
            scanner.next();
            return;
        }
        scanner.nextLine();

        List<Araba> filtrelenmisArabalar = new ArrayList<>();
        for (Araba araba : arabalar) {
            if (araba.getFiyat() <= maxFiyat) {
                filtrelenmisArabalar.add(araba);
            }
        }

        if (filtrelenmisArabalar.isEmpty()) {
            System.out.println("Belirtilen fiyat aralığında araç bulunamadı.");
        } else {
            System.out.println("\n=== Fiyat Aralığındaki Arabalar (Max " + String.format("%.2f", maxFiyat) + " TL) ===");
            for (int i = 0; i < filtrelenmisArabalar.size(); i++) {
                System.out.println("ID: " + i);
                System.out.println(filtrelenmisArabalar.get(i));
                System.out.println("--------------------------------------");
            }
        }
    }

    public void markayaGore(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Aranan marka: ");
        String markaAra = scanner.nextLine().toLowerCase();
        List<Araba> bulunanArabalar = new ArrayList<>();

        for (Araba a : arabalar) {
            if (a.getMarka().toLowerCase().contains(markaAra)) {
                bulunanArabalar.add(a);
            }
            if (bulunanArabalar.isEmpty()) {
                System.out.println("Marka '" + markaAra + "' için araç bulunamadı.");
            } else {
                System.out.println("\n=== Marka '" + markaAra + "'ya Göre Arabalar ===");
                for (int i = 0; i < bulunanArabalar.size(); i++) {
                    System.out.println("ID: " + i);
                    System.out.println(bulunanArabalar.get(i));
                    System.out.println("--------------------------------------");
                }
            }
        }

    }


    public void satinAl(Scanner scanner) {
        arabaListele(); // Mevcut arabaları ID'leriyle göster
        System.out.println("Almak istediğiniz arabayı girin.");     //////arabaları id ile alamıyorum id'leri yok.
        int id = scanner.nextInt();
        scanner.nextLine();

        Araba secilen = null;
        if (id >= 0 && id < arabalar.size()) {
            secilen = arabalar.get(id);
        }

        if (secilen == null) {
            System.out.println("Geçersiz ID. Araba bulunamadı.");
            return;
        }
        System.out.println("Müşteri adı:");
        String ad = scanner.nextLine();

        arabalar.remove(secilen);
        satisKayitlari.add(ad + "  tarafından satın alındı: \n" + secilen);
        System.out.println("Satış gerçekleşti.");

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Araba> cekilenArabalar = new ArrayList<>();


        try {
            System.out.println("Araba verileri çekiliyor... Lütfen bekleyiniz.");
            cekilenArabalar = Ozellikler.arabaIlanları();
            System.out.println(cekilenArabalar.size() + " adet araba verisi başarıyla çekildi.");
        } catch (IOException e) {
            System.err.println("Araba verileri çekilirken bir hata oluştu: " + e.getMessage());
            System.err.println("Program devam edecek ancak veri olmayabilir.");
        }

        Yazdir galeri = new Yazdir(cekilenArabalar);


        int secim;
        do {
            System.out.println("\n==== Galeri Yönetim Sistemi ====");
            System.out.println("1. Arabaları Listele");
            System.out.println("2. Araba Satın Al");
            System.out.println("3. Satışları Görüntüle");
            System.out.println("4. Fiyata Göre Filtrele");
            System.out.println("5. Markaya Göre Ara");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminizi girin: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1 -> galeri.arabaListele();
                case 2 -> galeri.satinAl(scanner);
                case 3 -> galeri.satislar();
                case 4 -> galeri.fiyataGore(scanner);
                case 5 -> galeri.markayaGore(scanner);
                case 6 -> System.out.println("Programdan çıkılıyor...");
                default -> System.out.println("Geçersiz seçim.");
            }
        } while (secim != 6);
    }
}