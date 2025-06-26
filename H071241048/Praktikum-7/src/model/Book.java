package src.model;

public class Book extends LibraryItem {
    private String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed) {
            throw new IllegalArgumentException("Buku ini sudah dipinjam");
        }
        if (days > 14) {
            throw new IllegalArgumentException("Buku tidak dapat dipinjam lebih dari 14 hari");
        }
        isBorrowed = true;
        return "item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }
}