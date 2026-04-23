1. Jelaskan alur kerja dari method konversiDesimalKeBiner!
2. Pada method konversiDesimalKeBiner, ubah kondisi perulangan menjadi while (kode != 0),
bagaimana hasilnya? Jelaskan alasannya!


Jawab:

1. Alur kerja method `konversiDesimalKeBiner(int nilai)` pada file `StackTugasMahasiswa11.java`:

   a. Method menerima parameter `nilai` bertipe `int` yang merupakan bilangan desimal yang akan dikonversi ke biner.

   b. Dibuat objek `StackKonversi11` baru bernama `stack` yang berfungsi sebagai tempat penyimpanan sementara sisa bagi (digit biner) dengan kapasitas 32 elemen.

   c. Proses konversi menggunakan perulangan `while (nilai > 0)`:
      - Menghitung sisa bagi dari `nilai % 2` dan disimpan pada variabel `sisa` (hasilnya pasti 0 atau 1).
      - Sisa tersebut di-`push` ke dalam stack.
      - Nilai diperbarui dengan `nilai = nilai / 2` (pembagian bulat).
      - Perulangan terus dilakukan hingga `nilai` menjadi 0.

   d. Dibuat String kosong bernama `biner` untuk menampung hasil konversi.

   e. Perulangan `while (!stack.isEmpty())` digunakan untuk mengambil data dari stack:
      - Method `pop()` mengambil elemen paling atas (terakhir dimasukkan) dari stack.
      - Elemen tersebut digabungkan ke String `biner`.
      - Karena sifat stack adalah LIFO (Last In First Out), sisa bagi terakhir (yang merupakan bit paling signifikan / MSB) akan keluar terlebih dahulu sehingga urutan biner menjadi benar.

   f. Method mengembalikan String `biner` sebagai hasil konversi.

   Contoh: Jika `nilai = 10`:
   - 10 % 2 = 0, push 0, nilai = 5
   - 5 % 2 = 1, push 1, nilai = 2
   - 2 % 2 = 0, push 0, nilai = 1
   - 1 % 2 = 1, push 1, nilai = 0
   - Isi stack dari bawah ke atas: [0, 1, 0, 1]
   - Saat di-pop satu per satu: 1, 0, 1, 0 → hasil biner = "1010"

2. Jika kondisi perulangan diubah menjadi `while (nilai != 0)`:

   - Untuk input bilangan **positif** (termasuk nilai 0-100 yang digunakan pada `MahasiswaDemo11.java` case 2), hasilnya akan **sama persis** dengan kondisi `while (nilai > 0)`. Alasannya, selama `nilai` positif, proses `nilai = nilai / 2` akan terus mengecil hingga mencapai 0, dan kondisi `nilai != 0` maupun `nilai > 0` sama-sama akan berhenti ketika `nilai` bernilai 0.

   - Untuk input `nilai = 0`, kedua kondisi juga sama-sama tidak akan menjalankan perulangan sehingga menghasilkan String kosong `""`.

   - Perbedaan baru muncul jika input berupa bilangan **negatif**:
     - Dengan `while (nilai > 0)`: perulangan tidak akan dijalankan sama sekali karena kondisi langsung `false`, sehingga hasilnya String kosong.
     - Dengan `while (nilai != 0)`: perulangan akan tetap berjalan untuk nilai negatif. Namun, hasil `nilai % 2` di Java bisa menghasilkan bilangan negatif (contoh: -5 % 2 = -1), sehingga digit yang di-push ke stack bukan hanya 0 atau 1, melainkan bisa -1. Hasil konversinya menjadi tidak valid, misalnya untuk nilai -10 akan menghasilkan String seperti "-10-10" yang bukan representasi biner yang benar.

   Kesimpulan: Penggunaan `while (nilai > 0)` lebih aman karena secara eksplisit membatasi input hanya untuk bilangan positif, sedangkan `while (nilai != 0)` berpotensi menghasilkan output yang salah jika input bernilai negatif. Untuk konteks program ini (nilai tugas mahasiswa 0-100 yang selalu positif), kedua kondisi menghasilkan output yang sama.
