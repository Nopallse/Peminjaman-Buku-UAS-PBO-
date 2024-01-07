import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Perpustakaan perpustakaan = new Perpustakaan();

        int choice;

        do {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Pelayanan User");
            System.out.println("2. Manajemen Buku");
            System.out.println("0. Exit");
            System.out.print("Pilih menu (0-2): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    menuPelayananUser(perpustakaan, scanner);
                    break;
                case 2:
                    menuManajemenBuku();
                    break;
                case 0:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }

        } while (choice != 0);
    }

    private static void menuPelayananUser(Perpustakaan perpustakaan, Scanner scanner) {
        int choice;

        do {
            System.out.println("\n===== MENU PELAYANAN USER =====");
            System.out.println("1. Peminjaman Buku");
            System.out.println("2. Pengembalian Buku");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih menu (0-2): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    menuPeminjamanBuku(perpustakaan, scanner);
                    break;
                case 2:
                    menuPengembalianBuku(perpustakaan, scanner);
                    break;
                case 0:
                    System.out.println("Kembali ke Menu Utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }

        } while (choice != 0);
    }

    private static void menuPeminjamanBuku(Perpustakaan perpustakaan, Scanner scanner) {
        System.out.println("\n===== MENU PEMINJAMAN BUKU =====");
        System.out.println("Jenis Member:");
        System.out.println("1. Reguler");
        System.out.println("2. Premium");
        System.out.print("Pilih jenis member (1-2): ");
        int jenisMember = scanner.nextInt();

switch (jenisMember) {
    case 1:
        Reguler regulerMember = new Reguler("Reguler Member Name");
        regulerMember.pinjamBuku();
        break;

        case 2:
        Premium premiumMember = new Premium("Premium Member Name");
        premiumMember.pinjamBuku();
        break;

    default:
        System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
}
    }

    private static void menuPengembalianBuku(Perpustakaan perpustakaan, Scanner scanner) {
        System.out.println("\n===== MENU PENGEMBALIAN BUKU =====");
        System.out.println("Jenis Member:");
        System.out.println("1. Reguler");
        System.out.println("2. Premium");
        System.out.print("Pilih jenis member (1-2): ");
        int jenisMember = scanner.nextInt();
    
        switch (jenisMember) {
            case 1:
                Reguler regulerMember = new Reguler("Reguler Member Name");
                regulerMember.kembalikanBuku();
                break;
    
            case 2:
                Premium premiumMember = new Premium("Premium Member Name");
                premiumMember.kembalikanBuku();
                break;
    
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
        }
    }



    public static void menuManajemenBuku() {
        int choice;
    
        do {
            System.out.println("\n===== MENU MANAJEMEN BUKU =====");
            System.out.println("1. Lihat Data Buku yang Tersedia");
            System.out.println("2. Input Data Buku");
            System.out.println("3. Update Data Buku");
            System.out.println("4. Hapus Data Buku");
            System.out.println("0. Kembali ke Menu Utama");
    
            try {
                System.out.print("Pilih menu (0-3): ");
                choice = scanner.nextInt();
    
                switch (choice) {
                    case 1:
                        view.getAllData();
                        break;
                    case 2:
                        // Logika untuk input data buku
                        try {
                            view.tambahData(scanner);
                        } catch (Exception e) {
                            System.err.println("Input tidak valid. Pastikan input sesuai dengan tipe data yang diminta.");
                        }
                        break;
                    case 3:
                        view.updateData();
                        break;
                    case 4:
                        view.deleteData();
                        break;
                    case 0:
                        System.out.println("Kembali ke Menu Utama.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
                }
            } catch (java.util.InputMismatchException e) {
                // Tangani ketika input bukan integer
                System.out.println("Input tidak valid. Mohon masukkan angka.");
                scanner.next(); // Konsumsi input yang tidak valid agar tidak terjadi loop tak terbatas
                choice = -1; // Set choice to an invalid value to repeat the loop
            }
    
        } while (choice != 0);
    }
    
}
