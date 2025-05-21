import java.util.*;

class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia.");
        }
        if (borrowedItems.contains(item)) {
            throw new IllegalStateException("Item sudah ada dalam daftar pinjaman.");
        }
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }


    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            throw new IllegalStateException("Item tidak sedang dipinjam anggota ini.");
        }
        borrowedItems.remove(item);
        item.returnItem();
        double fine = item.calculateFine(daysLate);
        return "Item " + item.title + " berhasil dikembalikan dengan denda: Rp " + (int) fine;
    }

    public String getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            return "Tidak ada item yang dipinjam";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("+---------+----------------------+\n");
        sb.append("| ID Item | Judul                |\n");
        sb.append("+---------+----------------------+\n");
        for (LibraryItem item : borrowedItems) {
            sb.append(String.format("| %-7d | %-20s |\n", item.itemId, item.title));
        }
        sb.append("+---------+----------------------+\n");
        return sb.toString();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
}