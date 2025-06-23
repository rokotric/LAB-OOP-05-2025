import java.util.*;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) throw new IllegalStateException("Item telah dipinjam");
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) throw new IllegalStateException("Item tidak ada di daftar pinjaman");
        borrowedItems.remove(item);
        item.returnItem();
        double fine = item.calculateFine(daysLate);
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + fine;
    }

    public String getBorrowedItems() {
        if (borrowedItems.isEmpty()) return "Tidak ada item yang dipinjam";
        StringBuilder sb = new StringBuilder();
        sb.append("+----+-------------------+\n");
        sb.append("| ID | Judul             |\n");
        sb.append("+----+-------------------+\n");
        for (LibraryItem item : borrowedItems) {
            sb.append(String.format("| %-2d | %-17s |\n", item.getItemId(), item.getTitle()));
        }
        return sb.toString();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
}
