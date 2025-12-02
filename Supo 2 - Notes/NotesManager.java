import java.util.ArrayList;
import java.util.Scanner;

public class NotesManager {
    private ArrayList<Notes> setOfNotes;

    public NotesManager() {
        setOfNotes = new ArrayList<>();
    }

    public void createNote(Scanner scanner) {
        System.out.print("Insert Name of Note:  ");
        String title = scanner.nextLine();

        setOfNotes.add(new Notes(title));
    }

    public void displayManager() {
        System.out.println("\n");
        for (int i = 1; i <= this.setOfNotes.size(); i++) {
            System.out.println("[" + String.valueOf(i) + "] " + this.setOfNotes.get(i-1).getTitle());
        }
    }

    public boolean deleteNote(int userIndex) {
        if ((1 <= userIndex) && (userIndex <= setOfNotes.size())) {
            setOfNotes.remove(userIndex - 1);
            return true;
        }
        else {
            System.out.println("Error: Invalid Index");
            return false;
        }
    }
    
    public Notes getNote(Scanner scanner) {
        int userIndex;
        while (true) {
            System.out.print("Select Index of Note:     ");
            userIndex = scanner.nextInt();
            scanner.nextLine();
            if ((userIndex >= 1) && (userIndex <= setOfNotes.size())) {
                return setOfNotes.get(userIndex - 1);
            }
            else {
                System.out.println("Error: Index not found");
            }
        }
    }
}