import java.util.*;

public class view {
  public static Scanner input = new Scanner(System.in);

  public static void getAllData() {
    // pesan header
    System.out.println("\n~~~ DATA BARANG ~~~");

    // data semua barangnya
    System.out.println(config.getAllData());

  }

  public static void tambahData(Scanner scanner) {
    System.out.println("===== INPUT DATA BUKU =====");
    System.out.print("ID: ");
    String id = scanner.next();
    System.out.print("Judul: ");
    String judul = scanner.next();
    System.out.print("Genre: ");
    String genre = scanner.next();

    int quantity = 1;

    if (config.tambahData(id, judul, genre, quantity)) {
        System.out.println("Data Barang berhasil ditambahkan!!");
        view.getAllData();
    } else {
        System.out.println("Data Barang gagal ditambahkan!!");
    }
}

  public static void updateData() {
    System.out.println("\n~~~ UPDATE DATA BARANG ~~~");
    System.out.print("Inputkan No id : ");
    String id = input.nextLine(); // Membersihkan baris baru dari input sebelumnya

    System.out.println("\nUbah Data Buku\n");

    // Judul Buku
    System.out.print("Judul buku (Biarkan kosong jika tidak ingin mengganti) : ");
    String judul = input.nextLine();

    // Genre Buku
    System.out.print("Genre buku (Biarkan kosong jika tidak ingin mengganti) : ");
    String genre = input.nextLine();

    int quantity = 1;

    if (config.updateData(id, judul, genre, quantity)) {
      System.out.println("Data buku berhasil diperbarui!!");
      view.getAllData();
    } else {
      System.out.println("Gagal memperbarui data buku!!");
    }
  }

  public static void deleteData() {
    System.out.println("\n:::DELETE DATA BARANG :::");
    System.out.print("Masukkan ID Buku : ");
    String id = input.nextLine();

    if (config.deleteData(id)) {
      System.out.println("Data Barang Berhasil Dihapus!!");
      getAllData();
    } else {
      System.out.println("Data Barang Gagal Dihapus!!");
    }

  }

  public static void pinjamBuku() {
    System.out.println("\n~~~ Peminjaman Buku ~~~");
    System.out.print("Inputkan id Buku: ");
    String id = input.nextLine(); // Membersihkan baris baru dari input sebelumnya

    // Judul Buku
    String judul = "";
    // Genre Buku
    String genre = "";

    // Quantity Buku
    int quantity = 0;

    if (config.updateData(id, judul, genre, quantity)) {
      System.out.println("Data barang berhasil diperbarui!!");
      view.getAllData();
    } else {
      System.out.println("Gagal memperbarui data barang!!");
    }
  }

}
