import java.util.*;

public class Reguler extends Member implements Peminjaman {
    public Scanner input = new Scanner(System.in);

    public Reguler(String nama) {
        super(nama, "Reguler");
    }

    public void pinjamBuku() {
        System.out.println("\n~~~ Peminjaman Buku ~~~");
        System.out.print("Inputkan Id Buku : ");
        String id = input.nextLine(); // Membersihkan baris baru dari input sebelumnya

        // Judul Buku
        String judul = "";

        // Genre Buku
        String genre = "";

        int quantity = 0;

        if (config.updateData(id, judul, genre, quantity)) {
            System.out.println("Buku berhasil dipinjam!!");
            view.getAllData();
        } else {
            System.out.println("Gagal meminjam buku!!");
        }
    }

    public void kembalikanBuku() {
        System.out.println("\n~~~ Pengembalian Buku ~~~");
        System.out.print("Inputkan Id Buku : ");
        String id = input.nextLine(); // Membersihkan baris baru dari input sebelumnya

        // Judul Buku
        String judul = "";

        // Genre Buku
        String genre = "";

        int quantity = 1;

        if (config.kembalikanBuku(id, judul, genre, quantity)) {
            System.out.println("Buku berhasil dikembalikan!!");
            view.getAllData();
        } else {
            System.out.println("Gagal mengembalikan buku!!");
        }
    }

    // Metode lain khusus untuk anggota Reguler jika diperlukan
}