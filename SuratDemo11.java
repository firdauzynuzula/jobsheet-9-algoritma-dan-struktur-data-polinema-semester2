import java.util.Scanner;

public class SuratDemo11 {
    static StackSurat11 stack;
    static Scanner input;
    static int idCounter = 1;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        stack = new StackSurat11(10);

        int pilihan;
        
        System.out.println("\n===== SISTEM MANAJEMEN SURAT IZIN MAHASISWA =====");

        while (true) {
            tampilMenu();
            System.out.print("Pilih menu (1-5): ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    terimaSurat();
                    break;
                case 2:
                    prosesSurat();
                    break;
                case 3:
                    lihatSuratTerakhir();
                    break;
                case 4:
                    cariSurat();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static void tampilMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Terima Surat Izin");
        System.out.println("2. Proses Surat Izin");
        System.out.println("3. Lihat Surat Izin Terakhir");
        System.out.println("4. Cari Surat");
        System.out.println("5. Keluar");
        System.out.println("------------");
    }

    static void terimaSurat() {
        System.out.println("\n=== TERIMA SURAT IZIN ===");
        
        if (stack.isFull()) {
            System.out.println("Stack penuh!");
            return;
        }

        String id = "SR" + String.format("%03d", idCounter++);
        
        System.out.print("Nama mahasiswa: ");
        String nama = input.nextLine();
        
        System.out.print("Kelas: ");
        String kelas = input.nextLine();
        
        System.out.print("Jenis izin (S=Sakit, I=Izin Keperluan): ");
        char jenis = input.nextLine().charAt(0);
        
        System.out.print("Durasi (hari): ");
        int durasi = input.nextInt();
        input.nextLine();

        Surat11 surat = new Surat11(id, nama, kelas, jenis, durasi);
        stack.push(surat);
        surat.tampilInfo();
    }

    static void prosesSurat() {
        System.out.println("\n=== PROSES SURAT IZIN ===");
        
        Surat11 surat = stack.pop();
        if (surat != null) {
            System.out.print("Surat diproses: ");
            surat.tampilInfo();
        }
    }

    static void lihatSuratTerakhir() {
        System.out.println("\n=== LIHAT SURAT TERAKHIR ===");
        
        Surat11 surat = stack.peek();
        if (surat != null) {
            surat.tampilInfo();
            
            System.out.print("Lihat semua surat? (y/n): ");
            String jawab = input.nextLine();
            if (jawab.equalsIgnoreCase("y")) {
                stack.displayAll();
            }
        }
    }

    static void cariSurat() {
        System.out.println("\n=== CARI SURAT ===");
        
        System.out.print("Cari nama mahasiswa: ");
        String nama = input.nextLine();
        
        Surat11 surat = stack.search(nama);
        if (surat != null) {
            System.out.print("Ditemukan: ");
            surat.tampilInfo();
        } else {
            System.out.println("Surat tidak ditemukan!");
        }
    }
}