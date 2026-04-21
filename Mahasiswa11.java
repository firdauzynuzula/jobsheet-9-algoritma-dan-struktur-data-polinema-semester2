public class Mahasiswa11 {
    String nim;
    String nama;
    String kelas;
    int nilai;

    Mahasiswa11() {}

    Mahasiswa11(String nim, String nama, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        nilai = -1;
    }
    
    void tugasDinilai(int nilai) {
        this.nilai = nilai;
    }
}
