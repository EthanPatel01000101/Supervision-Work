import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        Board<Cell> playerABoard = new Board<>(10, 10, Cell.Water);
        Board<Cell> playerBBoard = new Board<>(10, 10, Cell.Water);
        Board<Cell> playerAGuessBoard = new Board<>(10, 10, Cell.Unknown);
        Board<Cell> playerBGuessBoard = new Board<>(10, 10, Cell.Unknown);
        Scanner generalScanner = new Scanner(System.in);

        while (true) {
            System.out.print("Do you want to play against a person or computer?:    ");
            try {
                String s = generalScanner.nextLine().toLowerCase();
                boolean coin = false;
                int x = 0; int y = 0;
                    
                if ((s.equals("person")) || (s.equals("p"))) {
                    System.out.println("Player A");
                    placeBoatPlayer(5, playerABoard, generalScanner, "Carrier");
                    placeBoatPlayer(4, playerABoard, generalScanner, "Battleship");
                    placeBoatPlayer(3, playerABoard, generalScanner, "Cruiser");
                    placeBoatPlayer(3, playerABoard, generalScanner, "Submarine");
                    placeBoatPlayer(2, playerABoard, generalScanner, "Destroyer");

                    System.out.println("\nPlayer B");
                    placeBoatPlayer(5, playerBBoard, generalScanner, "Carrier");
                    placeBoatPlayer(4, playerBBoard, generalScanner, "Battleship");
                    placeBoatPlayer(3, playerBBoard, generalScanner, "Cruiser");
                    placeBoatPlayer(3, playerBBoard, generalScanner, "Submarine");
                    placeBoatPlayer(2, playerBBoard, generalScanner, "Destroyer");

                    while ((x != 17) && (y != 17)) {
                        if (coin) {
                            System.out.println("Player 1 " + Integer.toString(x) + "-" + Integer.toString(y) + " Player 2");
                            x += guessBoardPlayer(playerAGuessBoard, playerBBoard, generalScanner);
                        }
                        else {
                            System.out.println("Player 1 " + Integer.toString(x) + "-" + Integer.toString(y) + " Player 2");
                            y += guessBoardPlayer(playerBGuessBoard, playerABoard, generalScanner);
                        }
                        coin = !coin;
                    }
                    
                    if (x == 17) {
                        System.out.println("Player 1 Wins");
                    }
                    else {
                        System.out.println("Player 2 Wins");
                    }
                    break;
                }

                else if ((s.equals("computer")) || (s.equals("c"))) {
                    System.out.println("Player A");
                    placeBoatPlayer(5, playerABoard, generalScanner, "Carrier");
                    placeBoatPlayer(4, playerABoard, generalScanner, "Battleship");
                    placeBoatPlayer(3, playerABoard, generalScanner, "Cruiser");
                    placeBoatPlayer(3, playerABoard, generalScanner, "Submarine");
                    placeBoatPlayer(2, playerABoard, generalScanner, "Destroyer");

                    System.out.println("\nComputer Placing");
                    placeBoatBot(playerBBoard, 5);
                    placeBoatBot(playerBBoard, 4);
                    placeBoatBot(playerBBoard, 3);
                    placeBoatBot(playerBBoard, 3);
                    placeBoatBot(playerBBoard, 2);

                    while ((x != 17) && (y != 17)) {
                        if (coin) {
                            System.out.println("Player 1 " + Integer.toString(x) + "-" + Integer.toString(y) + " Computer");
                            x += guessBoardPlayer(playerAGuessBoard, playerBBoard, generalScanner);
                        }
                        else {
                            y += guessBoardBot(playerBGuessBoard, playerABoard);
                        }
                        coin = !coin;
                    }

                    if (x == 17) {
                        System.out.println("Player 1 Wins");
                    }
                    else {
                        System.out.println("Computer Wins");
                    }
                    break;
                }
                else {
                    throw new OutOfRangeError();
                }

            }
            catch (OutOfRangeError e) {
                System.out.println("Error: Enter either Person or Computer");
            }
        }
    }
    public static void placeBoatBot(Board<Cell> board, int boatLength) {
        Random gen = new Random();
        int x, y;
        boolean rotation;

        while (true) {
            x = gen.nextInt(10);
            y = gen.nextInt(10);
            rotation = gen.nextBoolean();
            try {
                if (((rotation) && (x + boatLength <= 11)) || ((!rotation) && (y + boatLength <= 11))) {
                    for (int i = 0; i < boatLength; i++) {
                        if (rotation) {
                            if (board.accessPosition(x + i, y) != Cell.Water) {
                                throw new BoatCollisionError();
                            }
                        }
                        else {
                            if (board.accessPosition(x, y + i) != Cell.Water) {
                                throw new BoatCollisionError();
                            } 
                        }
                    }
                    for (int i = 0; i < boatLength ; i++) {
                        if (rotation) {
                            board.changeAtPosition(x + i, y, Cell.Ship);
                        }
                        else {
                            board.changeAtPosition(x, y + i, Cell.Ship);
                        }
                    }
                }
                else {
                    throw new OutOfRangeError();
                }
                break;
            }
            catch (OutOfRangeError e) {}
            catch (BoatCollisionError e) {}
        }
    }
    public static void placeBoatPlayer(int boatLength, Board<Cell> baord, Scanner scanner, String boatName) {
        UI.outputBoard(baord);

        System.out.println("Placing " + boatName + " of length " + boatLength);
        
        int x = -1; int y = -1;
        boolean isHoriz;
        while (true) {
            while (true) {
                System.out.print("Insert X coord:   ");
                try {
                    String a = scanner.nextLine().toLowerCase();
                    switch (a) {
                        case "a":
                            x = 1; break;
                        case "b":
                            x = 2; break;
                        case "c":
                            x = 3; break;
                        case "d":
                            x = 4; break;
                        case "e":
                            x = 5; break;
                        case "f":
                            x = 6; break;
                        case "g":
                            x = 7; break;
                        case "h":
                            x = 8; break;
                        case "i":
                            x = 9; break;
                        case "j":
                            x = 10; break;
                        default:
                            throw new OutOfRangeError();
                    }
                    break;
                }
                catch (OutOfRangeError e1) {
                    System.out.println("Error: Enter Between A-J");
                }
            }

            while (true) {
                System.out.print("Insert Y coord:   ");
                try {
                    String a = scanner.nextLine();
                    y = Integer.parseInt(a);
                    if ((1 <= y) && (y <= 10)) {
                        break;
                    }
                    else {
                        throw new OutOfRangeError();
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error: Not An Integer");
                }
                catch (OutOfRangeError e1) {
                    System.out.println("Error: Integer Out Of Range");
                }
            }

            while (true) {
                System.out.print("Should the boat be horizontal?   ");
                try {
                    String in = scanner.nextLine().trim().toLowerCase();
                    if (in.equals("true") || in.equals(("t")) || in.equals("yes") || in.equals("y")) {
                        isHoriz = true;
                    }
                    else if (in.equals("false") || in.equals(("f")) || in.equals("no") || in.equals("n")) {
                        isHoriz = false;
                    }
                    else {throw new OutOfRangeError();}
                    break;
                }
                catch (OutOfRangeError e) {
                    System.out.println("Error: Not A True/False");
                }
            }

            try {
                if ((x == -1) || (y == -1)) {
                    throw new IllegalState();
                }
                else {
                    if (((isHoriz) && (x + boatLength <= 11)) || ((!isHoriz) && (y + boatLength <= 11))) {
                        for (int i = 0; i < boatLength; i++) {
                            if (isHoriz) {
                                if (baord.accessPosition(x-1 + i, y-1) != Cell.Water) {
                                    throw new BoatCollisionError();
                                }
                            }
                            else {
                               if (baord.accessPosition(x-1, y-1 + i) != Cell.Water) {
                                    throw new BoatCollisionError();
                                } 
                            }
                        }
                        for (int i = 0; i < boatLength ; i++) {
                            if (isHoriz) {
                                baord.changeAtPosition(x-1 + i, y-1, Cell.Ship);
                            }
                            else {
                                baord.changeAtPosition(x-1, y-1 + i, Cell.Ship);
                            }
                        }
                    }
                    else {
                        throw new OutOfRangeError();
                    }
                }
                break;
            }
            catch (OutOfRangeError e) {
                System.out.println("Boat Out of Range Error");
            }
            catch (IllegalState e ) {
                System.out.println("Something has gone very wrong");
            }
            catch (BoatCollisionError e) {
                System.out.println("Boat Intersects with an already existing boat");
            }
        }
    }

    public static int guessBoardPlayer(Board<Cell> guessBoard, Board<Cell> answerBoard, Scanner scanner) {
        UI.outputBoard(guessBoard);

        int x, y;
        Cell var;
        while (true) {
            while (true) {
                System.out.print("Insert X coord:   ");
                try {
                    String a = scanner.nextLine().toLowerCase();
                    switch (a) {
                        case "a":
                            x = 1; break;
                        case "b":
                            x = 2; break;
                        case "c":
                            x = 3; break;
                        case "d":
                            x = 4; break;
                        case "e":
                            x = 5; break;
                        case "f":
                            x = 6; break;
                        case "g":
                            x = 7; break;
                        case "h":
                            x = 8; break;
                        case "i":
                            x = 9; break;
                        case "j":
                            x = 10; break;
                        default:
                            throw new OutOfRangeError();
                    }
                    break;
                }
                catch (OutOfRangeError e1) {
                    System.out.println("Error: Enter Between A-J");
                }
            }

            while (true) {
                System.out.print("Insert Y coord:   ");
                try {
                    String a = scanner.nextLine();
                    y = Integer.parseInt(a);
                    if ((1 <= y) && (y <= 10)) {
                        break;
                    }
                    else {
                        throw new OutOfRangeError();
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error: Not An Integer");
                }
                catch (OutOfRangeError e1) {
                    System.out.println("Error: Integer Out Of Range");
                }
            }

            try {
                var = answerBoard.accessPosition(x-1, y-1);
                
                if (guessBoard.accessPosition(x-1, y-1) == Cell.Unknown) {
                    switch (var) {
                        case Water:
                            guessBoard.changeAtPosition(x-1, y-1, Cell.Miss);
                            return 0;
                        case Ship:
                            guessBoard.changeAtPosition(x-1, y-1, Cell.Hit);
                            return 1;
                        default:
                            throw new IllegalState();
                    }               
                }
                else {
                    throw new OutOfRangeError();
                }
            }
            catch (IllegalState e) {
                System.out.println("This should not happens");
            }
            catch (OutOfRangeError e) {
                System.out.println("Error: Already checked that square");
            }
        }
    }

    public static int guessBoardBot(Board<Cell> guessBoard, Board<Cell> answerBoard) {
        //guessBoard -> Unknown, Miss, Hit, answerBoard -> Water, Ship
        int x,y;
        Cell var;
        Random random = new Random();
        while (true) {
            x = random.nextInt(10);
            y = random.nextInt(10);
            var = answerBoard.accessPosition(x, y);
            try {
                switch (var) {
                    case Water:
                        guessBoard.changeAtPosition(x, y, Cell.Miss);
                        return 0;
                    case Ship:
                        guessBoard.changeAtPosition(x, y, Cell.Hit);
                        return 1;
                    default:
                        throw new IllegalState();
                }
            }
            catch (IllegalState e) {
                System.out.println("This should not happen");
            }
        }
    }
}