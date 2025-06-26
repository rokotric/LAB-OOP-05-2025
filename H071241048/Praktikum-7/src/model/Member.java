package src.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia");
        }
        borrowedItems.add(item);
        return item.borrowItem(days);
    }

    public String returnItem(LibraryItem item, int daysLate) {
        borrowedItems.remove(item);
        item.returnItem();
        double fine = item.calculateFine(daysLate);
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + String.format("%,.0f", fine);
    }

    public String getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            return "Tidak ada item yang dipinjam";
        }
        StringBuilder result = new StringBuilder();
        result.append("+-----+----------------------------+\n");
        result.append("| ID  | Judul                      |\n");
        result.append("+-----+----------------------------+\n");
        for (LibraryItem item : borrowedItems) {
            result.append(String.format("| %-3d | %-26s |\n", item.getItemId(), item.getTitle()));
        }
        result.append("+-----+----------------------------+");
        return result.toString();
    }
}