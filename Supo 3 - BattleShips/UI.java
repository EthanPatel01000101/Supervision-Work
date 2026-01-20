public class UI {

    public static void outputBoard(Board<Cell> arr) {
        System.out.print("   ");
        for (int i = 65; i < 65 + arr.getWidth(); i++) {
            System.out.print(" ");
            System.out.print((char) i);
        }
        int count = 0;
        for (Cell c: arr.getBoard()) {
            if (count % 10 == 0) {
                System.out.print("\n" + String.format("%1$2s ", Integer.toString((count / 10) + 1)) + " ");
            }
            switch (c) {
                case Miss:
                    System.out.print("\u001B[32mM\u001B[0m ");
                    break;
                case Hit:
                    System.out.print("\u001B[31mH\u001B[0m ");
                    break;
                case Unknown:
                    System.out.print("\u001B[34m?\u001B[0m ");
                    break;
                case Ship:
                    System.out.print("\u001B[33mS\u001B[0m ");
                    break;
                case Water:
                    System.out.print("\u001B[36m~\u001B[0m ");
                    break;
                default:
                    System.out.println("Something has gone wrong ");
                    break;
            }
            count++;
        }

        System.out.println("\n");
    }
}