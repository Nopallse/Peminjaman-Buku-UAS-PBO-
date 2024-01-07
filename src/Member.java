public class Member {
    private String nama;
    private String jenisKeanggotaan;

    public Member(String nama, String jenisKeanggotaan) {
        this.nama = nama;
        this.jenisKeanggotaan = jenisKeanggotaan;
    }

    public String getNama() {
        return nama;
    }

    public String getJenisKeanggotaan() {
        return jenisKeanggotaan;
    }

    // Metode lain yang mungkin dibutuhkan oleh semua anggota
}