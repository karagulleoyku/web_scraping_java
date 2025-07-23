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
            System.out.println("ID: " + i);
            System.out.println(arabalar.get(i));
        }
    }

    public void satislar() {
        if (satisKayitlari.isEmpty()) {
            System.out.println("Hiç satış kaydedilmedi.");
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
            System.out.println("Geçersiz giriş.");
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
            System.out.println("\nFiyat Aralığındaki Arabalar");
            for (int i = 0; i < filtrelenmisArabalar.size(); i++) {
                System.out.println("ID: " + i);
                System.out.println(filtrelenmisArabalar.get(i));
            }
        }
    }

    public void markayaGore(Scanner scanner) {
        System.out.print("Aranan marka: ");
        String markaAra = scanner.nextLine().toLowerCase();

        List<Araba> bulunanArabalar = new ArrayList<>();

        for (Araba a : arabalar) {
            if (a.getMarka().toLowerCase().contains(markaAra)) {
                bulunanArabalar.add(a);
            }
        if (bulunanArabalar.isEmpty()) {
                System.out.println("Araç bulunamadı.");
        } else {
                System.out.println("\nAranan Markaya Göre Arabalar");
                for (int i = 0; i < bulunanArabalar.size(); i++) {
                    System.out.println("ID: " + i);
                    System.out.println(bulunanArabalar.get(i));
                }
            }
        }

    }

    public void satinAl(Scanner scanner) {
        arabaListele();
        System.out.println("Almak istediğiniz arabayı girin.");
        int id = scanner.nextInt();
        scanner.nextLine();

        Araba secilen = null;
        if (id >= 0 && id < arabalar.size()) {
            secilen = arabalar.get(id);
        }

        if (secilen == null) {
            System.out.println("Araba bulunamadı.");
            return;
        }
        System.out.println("Müşteri adı:");
        String ad = scanner.nextLine();

        arabalar.remove(secilen);

        satisKayitlari.add(ad + "  tarafından satın alındı: \n" + secilen);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Araba> cekilenArabalar = new ArrayList<>();
        try {
            System.out.println("Araba verileri çekiliyor...");
            cekilenArabalar = Ozellikler.arabaIlanları();
            System.out.println(cekilenArabalar.size() + " adet araba verisi çekildi.");
        } catch (IOException e) {
            System.err.println("Araba verileri çekilirken bir hata oluştu: " + e.getMessage());
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