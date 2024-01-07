
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSet;

public class config {

  private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DB_URL = "jdbc:mysql://localhost:3306/perpustakaan";
  private static final String USER = "root";
  private static final String PASS = "";

  private static Connection connect;
  private static Statement statement;
  private static ResultSet resultData;

  // ini adalah method static connection
  public static void connection()

  {
    // method untuk melakukan koneksi ke database
    try {
      // registrasi driver yang akan dipakai
      Class.forName(JDBC_DRIVER);

      // buat koneksi ke database
      connect = DriverManager.getConnection(DB_URL, USER, PASS);

    } catch (Exception e) {
      // kalo ada error saat koneksi
      // maka tampilkan errornya
      e.printStackTrace();
    }

  }

  // Perbaikan di metode getAllData di kelas config
  public static String getAllData() {
    config.connection();

    // buat Map untuk menyimpan judul buku dan jumlah quantity
    Map<String, Integer> titleQuantityMap = new HashMap<>();

    try {
      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select all data from database
      String query = "SELECT id, judul, genre, quantity FROM buku";

      // eksekusi query-nya
      resultData = statement.executeQuery(query);

      // looping pengisian Map untuk judul buku dan jumlah quantity
      while (resultData.next()) {
        String judul = resultData.getString("judul");
        int quantity = resultData.getInt("quantity");

        // Update jumlah quantity jika judul sudah ada dalam Map
        titleQuantityMap.put(judul, titleQuantityMap.getOrDefault(judul, 0) + quantity);
      }

      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    // Membuat string untuk menampilkan judul dan jumlah quantity
    StringBuilder resultStringBuilder = new StringBuilder("judul\t\t\tstok tersedia\n");

    for (Map.Entry<String, Integer> entry : titleQuantityMap.entrySet()) {
      resultStringBuilder.append(entry.getKey()).append("\t\t\t").append(entry.getValue()).append("\n");
    }

    return resultStringBuilder.toString();
  }

  // Perbaikan di metode tambahData di kelas config
  public static boolean tambahData(String id, String judul, String genre, int quantity) {
    config.connection();
    boolean data = false;

    try {
      statement = connect.createStatement();

      // Perbaikan pada query
      String query = "INSERT INTO buku (id, judul, genre, quantity) VALUES ('" + id + "', '" + judul + "', '" + genre
          + "', " + quantity + ")";

      if (!statement.execute(query)) {
        data = true;
      }

      // Close statement dan koneksi
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }

  public static boolean updateData(String id, String judul, String genre, int quantity) {
    config.connection();
    boolean data = false;

    try {
      statement = connect.createStatement();

      String queryCek = "SELECT * FROM buku WHERE id = " + id;

      resultData = statement.executeQuery(queryCek);

      // Initialize judulCek with an empty string
      String judulCek = "";
      String genreCek = ""; // Initialize genreCek with an empty string
      int stokCek = 0;

      while (resultData.next()) {
        judulCek = resultData.getString("judul");
        genreCek = resultData.getString("genre");
        stokCek = resultData.getInt("quantity");
      }

      if (stokCek == 1) {

        if (!judul.equalsIgnoreCase("")) {
          judulCek = judul;
        }
        if (!genre.equalsIgnoreCase("")) {
          genreCek = genre;
        }

        if (quantity == 0) {
          stokCek = quantity;
        }

        String queryUpdate = "UPDATE buku SET judul = '" + judulCek + "', genre = '" + genreCek + "', quantity = "
            + stokCek + " WHERE id = " + id;

        if (!statement.execute(queryUpdate)) {
          data = true;
        } else {
          data = false;
        }

        // close statement dan close koneksi
        statement.close();
        connect.close();
      } else {
        System.out.println("Buku dengan ID " + id + " tidak tersedia.");

      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }

  public static boolean deleteData(String id) {
    connection();
    boolean data = false;

    try {

      statement = connect.createStatement();

      String query = "DELETE FROM buku WHERE id = " + id;
      // # String query = "UPDATE transaksi SET isActive = '0' WHERE no_faktur = " +
      // invoiceNumber;

      if (!statement.execute(query)) {
        data = true;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }

  public static boolean pinjamBuku(String id, String judul, String genre) {
    config.connection();
    boolean data = false;

    try {
      statement = connect.createStatement();

      String queryCek = "SELECT * FROM buku WHERE id = " + id;

      resultData = statement.executeQuery(queryCek);

      // Inisialisasi judulCek dengan string kosong
      String judulCek = "";
      String genreCek = ""; // Inisialisasi genreCek dengan string kosong
      int stokCek = 0;

      while (resultData.next()) {
        judulCek = resultData.getString("judul");
        genreCek = resultData.getString("genre");
        stokCek = resultData.getInt("quantity");
      }

      System.out.println("Stok " + stokCek);

      if (stokCek <= 0) {
        System.out.println("Buku dengan ID " + id + " tidak tersedia.");
      } else {
        // Kurangi jumlah stok
        stokCek--;

        if (!judul.equalsIgnoreCase("")) {
          judulCek = judul;
        }
        if (!genre.equalsIgnoreCase("")) {
          genreCek = genre;
        }

        String queryUpdate = "UPDATE buku SET judul = '" + judulCek + "', genre = '" + genreCek + "', quantity = "
            + stokCek + " WHERE id = " + id;

        if (!statement.execute(queryUpdate)) {
          data = true;
          System.out.println("Peminjaman berhasil!");
        } else {
          data = false;
        }
      }

      // Tutup statement dan koneksi
      statement.close();
      connect.close();

      // Tampilkan informasi buku yang diperbarui di luar loop
      view.getAllData();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }

  public static boolean kembalikanBuku(String id, String judul, String genre, int quantity) {
    config.connection();
    boolean data = false;

    try {
      statement = connect.createStatement();

      String queryCek = "SELECT * FROM buku WHERE id = " + id;

      resultData = statement.executeQuery(queryCek);

      // Initialize judulCek with an empty string
      String judulCek = "";
      String genreCek = ""; // Initialize genreCek with an empty string
      int stokCek = 0;

      while (resultData.next()) {
        judulCek = resultData.getString("judul");
        genreCek = resultData.getString("genre");
        stokCek = resultData.getInt("quantity");
      }

      if (stokCek == 0) {

        if (!judul.equalsIgnoreCase("")) {
          judulCek = judul;
        }
        if (!genre.equalsIgnoreCase("")) {
          genreCek = genre;
        }

        stokCek = 1;

        String queryUpdate = "UPDATE buku SET judul = '" + judulCek + "', genre = '" + genreCek + "', quantity = "
            + stokCek + " WHERE id = " + id;

        if (!statement.execute(queryUpdate)) {
          data = true;
        } else {
          data = false;
        }

        // close statement dan close koneksi
        statement.close();
        connect.close();
      } else {
        System.out.println("Buku dengan ID " + id + " tidak tersedia.");

      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }

}
