1. Lakukan perbaikan pada kode program, sehingga keluaran yang dihasilkan sama dengan verifikasi
hasil percobaan! Bagian mana yang perlu diperbaiki?
2. Berapa banyak data tugas mahasiswa yang dapat ditampung di dalam Stack? Tunjukkan potongan
kode programnya!
3. Mengapa perlu pengecekan kondisi !isFull() pada method push? Kalau kondisi if-else tersebut
dihapus, apa dampaknya?
4. Modifikasi kode program pada class MahasiswaDemo dan StackTugasMahasiswa sehingga
pengguna juga dapat melihat mahasiswa yang pertama kali mengumpulkan tugas melalui operasi
lihat tugas terbawah!
5. Tambahkan method untuk dapat menghitung berapa banyak tugas yang sudah dikumpulkan saat
ini, serta tambahkan operasi menunya!
6. Commit dan push kode program ke Github



jawab:

1. Bagian yang diperbaiki ada dua:

   **a. Method `print()` di `StackTugasMahasiswa11.java`**  
   Loop semula berjalan dari `i = 0` ke `top` (bawah ke atas), sehingga urutan tampilan terbalik dari sifat stack (yang seharusnya menampilkan data terbaru/teratas lebih dulu). Diperbaiki menjadi dari `i = top` ke `0`:
   ```java
   // Sebelum (salah)
   for (int i = 0; i <= top; i++) { ... }

   // Sesudah (benar)
   for (int i = top; i >= 0; i--) { ... }
   ```

   **b. Kondisi `while` dan menu keluar di `MahasiswaDemo11.java`**  
   Semula tidak ada opsi keluar, sehingga program tidak bisa diakhiri dengan normal. Diperbaiki dengan menambahkan menu `0. Keluar` dan mengubah kondisi loop menjadi `while (pilih != 0)`.

2. Stack dapat menampung **5 data** tugas mahasiswa. Ditunjukkan pada baris berikut di `MahasiswaDemo11.java`:
   ```java
   StackTugasMahasiswa11 stack = new StackTugasMahasiswa11(5);
   ```
   Dan di konstruktor `StackTugasMahasiswa11.java`:
   ```java
   public StackTugasMahasiswa11(int size) {
       this.size = size;
       stack = new Mahasiswa11[size]; // array berukuran 5
       top = -1;
   }
   ```

3. Pengecekan `!isFull()` diperlukan agar program tidak mencoba menyimpan data ke indeks di luar batas array. Jika kondisi `if-else` tersebut dihapus, ketika stack sudah penuh (`top == size - 1`), baris `top++` akan membuat `top` menjadi sama dengan `size`, dan akses `stack[top]` akan menyebabkan **`ArrayIndexOutOfBoundsException`** karena indeks valid hanya dari `0` sampai `size - 1`. Program akan crash secara tiba-tiba.

4. Modifikasi telah dilakukan:

   **Di `StackTugasMahasiswa11.java`**, ditambahkan method `peekBottom()`:
   ```java
   public Mahasiswa11 peekBottom() {
       if (!isEmpty()) {
           return stack[0]; // indeks 0 = mahasiswa pertama mengumpulkan
       } else {
           System.out.println("Stack kosong! Tidak ada tugas.");
           return null;
       }
   }
   ```

   **Di `MahasiswaDemo11.java`**, ditambahkan menu opsi 5:
   ```java
   case 5:
       Mahasiswa11 terbawah = stack.peekBottom();
       if (terbawah != null) {
           System.out.println("Tugas pertama dikumpulkan oleh " + terbawah.nama);
       }
       break;
   ```

5. Modifikasi telah dilakukan:

   **Di `StackTugasMahasiswa11.java`**, ditambahkan method `count()`:
   ```java
   public int count() {
       return top + 1; // top dimulai dari -1, sehingga jumlah elemen = top + 1
   }
   ```

   **Di `MahasiswaDemo11.java`**, ditambahkan menu opsi 6:
   ```java
   case 6:
       System.out.println("Jumlah tugas yang sudah dikumpulkan: " + stack.count());
       break;
   ```

6. Kode telah di-commit dan di-push ke Github.
