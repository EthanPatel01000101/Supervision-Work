import java.time.LocalDate;
import java.util.ArrayList;

public class Notes {
    private ArrayList<String> message;
    private String title;
    private final Date dateCreated;
    private Date dateModified;
    private boolean locked;

    public Notes(String myTitle) {
        this.message = new ArrayList<>();
        this.title = myTitle;
        LocalDate now = LocalDate.now();
        this.dateCreated = new Date(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        this.dateModified = new Date(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        this.locked = false;
    }

    public void lockNotes() {this.locked = true;}
    public void unlockNotes() {this.locked = false;}
    public String getTitle() {return this.title;}
    public int getLengthMessage() {return this.message.size();}

    public void printNote() {
        //present to the user starting from 1
        //internally ArrayList start from 0
        
        System.out.println(title + "    Date Modified:  " + dateModified.formatDate() + "    Date Created:    " + dateCreated.formatDate());
        for (int i = 1; i <= this.message.size(); i++) {
            System.out.println("[" + String.valueOf(i) + "] " + this.message.get(i - 1));
        }
    }

    public boolean editNote(int index, String message) {
        if (!locked) {
            if ((index <= 0)) {
                System.out.println("Error: Invalid Index");
                return false;
            }
            else {
                LocalDate local = LocalDate.now();
                if (index <= this.message.size()) {
                    this.message.remove(index - 1);
                } else  {
                this.message.add(message);
                }
                this.dateModified = new Date(local.getYear(), local.getMonthValue(), local.getDayOfMonth());
                return true;
            }
        }
        else {
            System.out.println("Error: Note is Locked");
            return false;
        }
    }

    public boolean addNote(String message) {
        if (!locked) {
            this.message.add(message);
            return true;
        }
        else {
            System.out.println("Error: Note is Locked");
            return false;
        }
    }
}