import java.util.*;

class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        logger.logActivity(item.title + " berhasil ditambahkan");
        return item.title + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        return items.stream().filter(i -> i.itemId == itemId).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item tidak ditemukan."));
    }

    public Member findMemberById(int memberId) {
        return members.stream().filter(m -> m.getMemberId() == memberId).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Anggota tidak ditemukan."));
    }

    public String addMember(Member member) {
        members.add(member);
        logger.logActivity("Anggota " + member.getName() + " ditambahkan");
        return "Anggota berhasil ditambahkan";
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();

        sb.append("+---------+----------------------+------------+\n");
        sb.append("| ID Item | Judul                | Status     |\n");
        sb.append("+---------+----------------------+------------+\n");
        for (LibraryItem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-7d | %-20s | %-10s |\n", item.itemId, item.title, status));
        }
        sb.append("+---------+----------------------+------------+\n");

        sb.append("\nDaftar Anggota:\n");
        sb.append("+------------+----------------------+\n");
        sb.append("| ID Anggota | Nama                 |\n");
        sb.append("+------------+----------------------+\n");
        for (Member member : members) {
            sb.append(String.format("| %-10d | %-20s |\n", member.getMemberId(), member.getName()));
        }
        sb.append("+------------+----------------------+\n");

        return sb.toString();
    }


    //sama aja dengan getalog
    public LibraryLogger getLogger() {
        return logger;
    }
}