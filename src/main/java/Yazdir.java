import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Yazdir {
    List<Araba> araba = new ArrayList<>();
    List<String> satisKayitlari = new ArrayList<>();

    public Yazdir() {

    }

    public void arabaListele() {
        for (Araba a : araba) {
            System.out.println(a);
        }
    }

    public void satislar() {
        System.out.println("\n=== Satış Kayıtları ===");
        for (String kayit : satisKayitlari) {
            System.out.println(kayit);
        }
    }

    public void fiyataGore(Scanner scanner) {
        System.out.print("Maksimum fiyatı girin: ");
        double maxFiyat = scanner.nextDouble();
        for (Araba a : araba) {
            if (a.fiyat <= maxFiyat) {
                System.out.println(a);
            } else {
                System.out.println("Bu kriterde araç bulunmamakta.");
                return;

            }
        }
    }

    public void markayaGore(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Aranan marka: ");
        String markaAra = scanner.nextLine();
        for (Araba a : araba) {
            if (a.marka.toLowerCase().contains(markaAra)) {
                System.out.println(a);
                return;
            }
        }
    }

    public void satinAl(Scanner scanner) {
        System.out.println("Almak istediğiniz arabanın id'sini girin.");
        int id = scanner.nextInt();
        scanner.nextLine();

        Araba secilen = null;
        /*for (Araba a : araba) {
            if (a.id == id) {
                secilen = a;
                break;
            }
        }*/
        if (secilen == null) {
            System.out.println("Araba yok..");
            return;
        }
        System.out.println("Müşteri adı:");
        String ad = scanner.nextLine();
        araba.remove(secilen);
        satisKayitlari.add(ad + "  tarafından satın alındı: \n" + secilen);
        System.out.println("Satış gerçekleşti.");

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Yazdir galeri = new Yazdir();
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