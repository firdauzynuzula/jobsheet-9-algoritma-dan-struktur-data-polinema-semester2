import java.util.Scanner;   

public class MahasiswaDemo11 {
    public static void main(String[] args) {
        StackTugasMahasiswa11 stack = new StackTugasMahasiswa11(5);
        Scanner scan = new Scanner(System.in);

        int pilih;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Mengumpulkan tugas");
            System.out.println("2. Menilai tugas");
            System.out.println("3. Melihat tugas Teratas");
            System.out.println("4. Melihat Daftar Tugas");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            switch (pilih) {
                    case 1:
                        System.out.print("Nama: ");
                        String nama = scan.next();
                        System.out.print("NIM: ");
                        String nim = scan.next();
                        System.out.print("Kelas: ");
                        String kelas = scan.next();
                        Mahasiswa11 mhs = new Mahasiswa11(nim, nama, kelas);
                        stack.push(mhs);
                        System.out.printf("Tugas %s berhasil dikumpulkan!\n", nama);
                        break;

                    case 2:
                        Mahasiswa11 dinilai = stack.pop();
                        if (dinilai != null) {
                            System.out.print("Menilai tugas dari " + dinilai.nama + ": ");
                            System.out.print("Masukkan nilai (0-100): ");
                            int nilai = scan.nextInt();
                            dinilai.tugasDinilai(nilai);
                            System.out.printf("Nilai tugas %s adalah %d\n", dinilai.nama, nilai);
                        }
                        break;
                    
                        case 3:
                            Mahasiswa11 lihat = stack.peek();
                            if (lihat != null) {
                                System.out.println("Tugas terakhir dikumpulkan oleh " + lihat.nama);
                            }
                            break;
                        case 4:
                            System.out.println("Daftar semua tugas");
                            System.out.println("Nama\tNIM\tKelas");
                            stack.print();
                            break;    
                    default:
                        System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (pilih >= 1 && pilih <= 4);
    }
}
