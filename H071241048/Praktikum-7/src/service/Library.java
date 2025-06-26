package src.service;

import src.model.LibraryItem;
import src.model.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
        logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) {
        items.add(item);
        logger.logActivity(item.getTitle() + " berhasil ditambahkan");
        return item.getTitle() + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        throw new NoSuchElementException("Item tidak ditemukan");
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        throw new NoSuchElementException("Member tidak ditemukan");
    }

    public String getLibraryStatus() {
        StringBuilder result = new StringBuilder();
        result.append("+-----+----------------------------+-------------------------------+-----------+\n");
        result.append("| ID  | Judul                      | Deskripsi                     | Status    |\n");
        result.append("+-----+----------------------------+-------------------------------+-----------+\n");

        for (LibraryItem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            result.append(String.format("| %-3d | %-26s | %-29s | %-9s |\n",
                    item.getItemId(),
                    item.getTitle(),
                    item.getDescription(), // tambahan
                    status));
        }

        result.append("+-----+----------------------------+-------------------------------+-----------+");
        return result.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public void addMember(Member member) { //tambahabn
        members.add(member);
        logger.logActivity("Member " + member.getName() + " ditambahkan");
    }


    public String borrowItem(int memberId, int itemId, int days) { // tambahann
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);
        String result = member.borrow(item, days);
        logger.logActivity(item.getTitle() + " dipinjam oleh " + member.getName());
        return result;
    }

    public String returnItemLengkap(int memberId, int itemId, int daysLate) { // tambahann
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);
        String result = member.returnItem(item, daysLate);
        logger.logActivity(item.getTitle() + " dikembalikan oleh " + member.getName());
        return result;
    }

    public boolean isItemIdExists(int id) { // tambahan
        for (LibraryItem item : items) {
            if (item.getItemId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean isMemberIdExists(int id) { //tambahan
        for (Member member : members) {
            if (member.getMemberId() == id) {
                return true;
            }
        }
        return false;
    }
}