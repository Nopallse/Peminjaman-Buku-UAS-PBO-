import java.util.*;

public class Premium extends Member implements Peminjaman {
    public static Scanner input = new Scanner(System.in);

    public Premium(String nama) {
        super(nama, "Premium");
    }

    public void pinjamBuku() {
        System.out.println("\n~~~ Peminjaman Buku ~~~");
    
        System.out.print("Banyak buku yang di pinjam (maksimal 3) : ");
        int jumlahPeminjaman = input.nextInt();
        
    
        // Membersihkan karakter baris baru dari buffer
        input.nextLine();
    
        if (jumlahPeminjaman > 3) {
            System.out.println("Member premium hanya dapat meminjam maksimal 3 buku.");
            jumlahPeminjaman = 3;
        }
    
        for (int i = 0; i < jumlahPeminjaman; i++) {
            System.out.print("Inputkan Id Buku : ");
            String id = input.nextLine();
    
            // Judul Buku
            String judul = "";
    
            // Genre Buku
            String genre = "";
    
            int quantity = 0;
    
            if (config.updateData(id, judul, genre, quantity)) {
                System.out.println("Buku berhasil dipinjam!!");
            } else {
                System.out.println("Gagal meminjam buku!!");
            }
        }
    
        view.getAllData();
    }

    public void kembalikanBuku() {
        System.out.println("\n~~~ Pengembalian Buku ~~~");
        System.out.print("Banyak buku yang di kembalikan (maksimal 3) : ");
        int jumlahPengembalian = input.nextInt();    
        // Membersihkan karakter baris baru dari buffer
        input.nextLine();
    
        if (jumlahPengembalian > 3) {
            System.out.println("Member premium hanya dapat mengembalikan maksimal 3 buku.");
            jumlahPengembalian = 3;
        }
    
        for (int i = 0; i < jumlahPengembalian; i++) {
        System.out.print("Inputkan Id Buku : ");
        String id = input.nextLine(); // Membersihkan baris baru dari input sebelumnya
    
        // Judul Buku
        String judul = "";
    
        // Genre Buku
        String genre = "";
    
        int quantity = 1;
        
        
        if (config.kembalikanBuku(id, judul, genre,quantity)) {
            System.out.println("Buku berhasil dikembalikan!!");
        } else {
            System.out.println("Gagal mengembalikan buku!!");
        }
    }
    view.getAllData();

    }

    // Metode lain khusus untuk anggota Premium jika diperlukan
}

