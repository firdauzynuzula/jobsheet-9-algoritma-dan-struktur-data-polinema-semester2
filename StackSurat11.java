public class StackSurat11 {
    Surat11[] stackSurat;
    int top;
    int maxSize;

    // Constructor
    public StackSurat11(int maxSize) {
        this.maxSize = maxSize;
        this.stackSurat = new Surat11[maxSize];
        this.top = -1; // top = -1 menunjukkan stack kosong
    }

    // Method push (menambah surat)
    public void push(Surat11 surat) {
        if (isFull()) {
            System.out.println("Stack penuh!");
            return;
        }
        top++;
        stackSurat[top] = surat;
        System.out.println("Surat " + surat.idSurat + " ditambahkan");
    }

    // Method pop (mengeluarkan surat)
    public Surat11 pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return null;
        }
        Surat11 surat = stackSurat[top];
        top--;
        return surat;
    }

    // Method peek (melihat surat teratas)
    public Surat11 peek() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return null;
        }
        return stackSurat[top];
    }

    // Method untuk cek stack kosong
    public boolean isEmpty() {
        return top == -1;
    }

    // Method untuk cek stack penuh
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // Method untuk mendapat jumlah elemen
    public int size() {
        return top + 1;
    }

    // Method untuk mencari surat berdasarkan nama
    public Surat11 search(String nama) {
        for (int i = top; i >= 0; i--) {
            if (stackSurat[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                return stackSurat[i];
            }
        }
        return null;
    }

    // Method untuk menampilkan semua surat
    public void displayAll() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return;
        }
        System.out.println("\n=== DAFTAR SURAT ===");
        for (int i = top; i >= 0; i--) {
            System.out.print((top - i + 1) + ". ");
            stackSurat[i].tampilInfo();
        }
        System.out.println("Total: " + size() + " surat\n");
    }
}