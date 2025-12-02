import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NotesManager nm = new NotesManager();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 8) {
            choice = startingMenu(scanner);
            if (choice == 1) {
                nm.createNote(scanner);
            }
            else if (choice == 2) {
                nm.displayManager();
                boolean flag = false;
                int num;
                while (!flag) {
                    System.out.println("Insert index to delete:     ");
                    num = scanner.nextInt();
                    scanner.nextLine();
                    flag = nm.deleteNote(num);
                }
            }
            else if (choice == 3) {
                nm.displayManager();
                Notes note = nm.getNote(scanner);
                boolean validInput = false;

                note.printNote();
                
                while (!validInput) {
                    System.out.print("Insert Index to edit:   ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    if ((index >= 1) && (index <= note.getLengthMessage())) {
                        System.out.print("Insert Message to edit:     ");
                        note.editNote(choice, scanner.nextLine());
                    }
                }
            }
            else if (choice == 4) {
                nm.displayManager();
                Notes note = nm.getNote(scanner);
                System.out.print("Insert Message to edit:     ");
                note.addNote(scanner.nextLine());
            }
            else if (choice == 5) {
                nm.displayManager();
                Notes note = nm.getNote(scanner);
                note.printNote();
            }
            else if (choice == 6) {
                nm.displayManager();
                Notes note = nm.getNote(scanner);
                note.lockNotes();
            }
            else if (choice == 7) {
                nm.displayManager();
                Notes note = nm.getNote(scanner);
                note.unlockNotes();
            }
            System.out.println("\n");
        }
        scanner.close();
    }

    private static int startingMenu(Scanner scanner) {
        int num;
        System.out.println("[1] Create Notes");
        System.out.println("[2] Delete Notes");
        System.out.println("[3] Edit Notes");
        System.out.println("[4] Add Notes");
        System.out.println("[5] View Notes");
        System.out.println("[6] Lock Notes");
        System.out.println("[7] Unlock Notes");
        System.out.println("[8] Quit Software");
        
        while (true) {
            System.out.print("Select Choice:  ");
            num = scanner.nextInt();
            if ((num >= 1) && (num <= 8)) {
                scanner.nextLine();
                return num;
            }
        }
    }

}