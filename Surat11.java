
public class Surat11 {
    String idSurat;
    String namaMahasiswa;
    String kelas;
    char jenisIzin;
    int durasi;

    // Constructor default
    public Surat11() {
    }

    // Constructor dengan parameter
    public Surat11(String idSurat, String namaMahasiswa, String kelas, char jenisIzin, int durasi) {
        this.idSurat = idSurat;
        this.namaMahasiswa = namaMahasiswa;
        this.kelas = kelas;
        this.jenisIzin = jenisIzin;
        this.durasi = durasi;
    }

    // Method untuk menampilkan informasi surat
    void tampilInfo() {
        String tipeIzin = (jenisIzin == 'S') ? "Sakit" : "Izin Keperluan Lain";
        System.out.println("ID: " + idSurat + " | Nama: " + namaMahasiswa + " | Kelas: " + kelas + " | Tipe: " + tipeIzin + " | Durasi: " + durasi + " hari");
    }
}