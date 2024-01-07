public class Perpustakaan {
    private static final int MAX_BUKU = 100; // Maximum number of books
    private Buku[] daftarBuku;
    private int jumlahBuku;

    public Perpustakaan() {
        this.daftarBuku = new Buku[MAX_BUKU];
        this.jumlahBuku = 0;
    }

    public Buku[] getDaftarBuku() {
        return daftarBuku;
    }

    public int getJumlahBuku() {
        return jumlahBuku;
    }

    

}
