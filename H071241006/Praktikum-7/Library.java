import java.util.*;

public class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public void addItem(LibraryItem item) {
        items.add(item);
        logger.logActivity(item.getTitle() + " berhasil ditambahkan");
    }

    public void addMember(Member member) {
        members.add(member);
        logger.logActivity("Anggota " + member.getName() + " berhasil ditambahkan");
    }

    public LibraryItem findById(int id) {
        return items.stream()
            .filter(item -> item.getItemId() == id)
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Item tidak ditemukan"));
    }

    public Member findMemberById(int id) {
        return members.stream()
            .filter(m -> m.getMemberId() == id)
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Anggota tidak ditemukan"));
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("+-----+----------+----------+\n");
        sb.append("| ID  | Judul    | Status   |\n");
        sb.append("+-----+----------+----------+\n");
        for (LibraryItem item : items) {
            sb.append(String.format("| %-3d | %-8s | %-8s |\n",
                    item.getItemId(),
                    item.getTitle(),
                    item.isBorrowed() ? "Dipinjam" : "Tersedia"));
        }
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}
