public class Buku {
    private String id;
    private String judul;
    private String genre;
    private int quantity;

    public Buku(String id, String judul, String genre, int quantity) {
        this.id = id;
        this.judul = judul;
        this.genre = genre;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getGenre() {
        return genre;
    }

    public int getQuantity() {
        return quantity;
    }

    // Add setter methods
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
