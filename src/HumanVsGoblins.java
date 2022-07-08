import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class HumanVsGoblins {
    public static void main(String[] args) {
        Humans player = new Humans();
        Goblins goblin = new Goblins();
        Scanner playerInput = new Scanner(System.in);
        Object[][][] levels = {
                {
                        {"\uD83D\uDD1A", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA"},
                        {"\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA"},
                        {"\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDFEA"},
                        {"\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA"},
                        {"\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA"},
                        {"\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDFEA"},
                        {"\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDFEA"},
                        {"\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83E\uDDDD"}
                },
                {
                        {"\uD83D\uDD1A", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA"},
                        {"\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA"},
                        {"\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDC79"},
                        {"\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA"},
                        {"\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA"},
                        {"\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDFEA"},
                        {"\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDC79", "\uD83D\uDFEA", "\uD83D\uDFEA"},
                        {"\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83D\uDFEA", "\uD83E\uDDDD"}
                },

        };

        System.out.println("Welcome to Humans Vs Goblins");
        System.out.println("What is your name?");
        String playerName = playerInput.nextLine();
        player.setName(playerName);
        System.out.println("Ready to play? y/n");
        String playAgain = playerInput.nextLine();
        int lvl = 0;

        boolean running;
        do {
            running = true;
            System.out.println(" W = North\nS = South\nA=West\nD=East");
            System.out.println("Here are your starting stats:");
            System.out.println(player.getName());
            System.out.println("Health: " + player.getHealth());
            System.out.println("Strength: " + player.getStrength());
            while (running) {
                Object[][] gameBoard = levels[lvl];
                for (int i = 0; i < gameBoard.length; i++) {
                    for (int j = 0; j < gameBoard[i].length; j++) {
                        System.out.print(gameBoard[i][j] + "\t");
                    }
                    System.out.println("\n");
                }

                String input = playerInput.nextLine().toLowerCase();
                int[] oldCords = player.getCords();
                int[] newCords = new int[2];
                if (input.startsWith("w")) {
                    newCords[0] = oldCords[0] - 1;
                    newCords[1] = oldCords[1];
                    player.setCords(newCords);
                    Object temp = gameBoard[newCords[0]][newCords[1]];
                    //temp = gameBoard[oldCords[0]][oldCords[1]];
                    if (temp.equals("\uD83D\uDC79")) {
                        System.out.println("ATTACK!!!");
                        player.attack();
                        if (player.getHealth() > 0) {
                            System.out.println("You are victorious!");
                            gameBoard[oldCords[0]][oldCords[1]] = "\uD83D\uDFEA";
                        } else {
                            System.out.println("you died in combat");
                            running = false;
                            gameBoard[newCords[0]][newCords[1]] = "\uD83D\uDC79";
                            gameBoard[oldCords[0]][oldCords[1]] = "\uD83D\uDFEA";
                            player.setCords(new int[]{7, 7});
                            player.setHealth(100);
                            player.setStrength(ThreadLocalRandom.current().nextInt(10, 20));
                            goblin.setHealth(30);
                            goblin.setStrength(ThreadLocalRandom.current().nextInt(8, 30));
                            gameBoard[0][0] = "\uD83D\uDD1A";
                            gameBoard[7][7] = "\uD83E\uDDDD";
                        }
                    }
                    if (running) {
                        gameBoard[newCords[0]][newCords[1]] = "\uD83E\uDDDD";
                    }

                } else if (input.startsWith("s")) {
                    newCords[0] = oldCords[0] + 1;
                    newCords[1] = oldCords[1];
                    player.setCords(newCords);
                    Object temp = gameBoard[newCords[0]][newCords[1]];
                    //temp = gameBoard[oldCords[0]][oldCords[1]];
                    if (temp.equals("\uD83D\uDC79")) {
                        System.out.println("ATTACK!!!");
                        player.attack();
                        if (player.getHealth() > 0) {
                            System.out.println("You are victorious!");
                            gameBoard[oldCords[0]][oldCords[1]] = "\uD83D\uDFEA";
                        } else {
                            System.out.println("You died in combat");
                            running = false;
                            gameBoard[newCords[0]][newCords[1]] = "\uD83D\uDC79";
                            gameBoard[oldCords[0]][oldCords[1]] = "\uD83D\uDFEA";
                            player.setCords(new int[]{7, 7});
                            player.setHealth(100);
                            player.setStrength(ThreadLocalRandom.current().nextInt(10, 20));
                            goblin.setHealth(30);
                            goblin.setStrength(ThreadLocalRandom.current().nextInt(8, 30));
                            gameBoard[0][0] = "\uD83D\uDD1A";
                            gameBoard[7][7] = "\uD83E\uDDDD";
                        }
                    }
                    if (running) {
                        gameBoard[newCords[0]][newCords[1]] = "\uD83E\uDDDD";
                    }
                } else if (input.startsWith("d")) {
                    newCords[0] = oldCords[0];
                    newCords[1] = oldCords[1] + 1;
                    player.setCords(newCords);
                    Object temp = gameBoard[newCords[0]][newCords[1]];
                    //temp = gameBoard[oldCords[0]][oldCords[1]];
                    if (temp.equals("\uD83D\uDC79")) {
                        System.out.println("ATTACK!!!");
                        player.attack();
                        if (player.getHealth() > 0) {
                            System.out.println("You are victorious!");
                            gameBoard[oldCords[0]][oldCords[1]] = "\uD83D\uDFEA";
                        } else {
                            System.out.println("You died in combat");
                            running = false;
                            gameBoard[newCords[0]][newCords[1]] = "\uD83D\uDC79";
                            gameBoard[oldCords[0]][oldCords[1]] = "\uD83D\uDFEA";
                            player.setCords(new int[]{7, 7});
                            player.setHealth(100);
                            player.setStrength(ThreadLocalRandom.current().nextInt(10, 20));
                            goblin.setHealth(30);
                            goblin.setStrength(ThreadLocalRandom.current().nextInt(8, 30));
                            gameBoard[0][0] = "\uD83D\uDD1A";
                            gameBoard[7][7] = "\uD83E\uDDDD";
                        }
                    }
                    if (running) {
                        gameBoard[newCords[0]][newCords[1]] = "\uD83E\uDDDD";
                    }
                } else if (input.startsWith("a")) {
                    newCords[0] = oldCords[0];
                    newCords[1] = oldCords[1] - 1;
                    player.setCords(newCords);
                    Object temp = gameBoard[newCords[0]][newCords[1]];
                    //temp = gameBoard[oldCords[0]][oldCords[1]];
                    if (temp.equals("\uD83D\uDC79")) {
                        System.out.println("ATTACK!!!");
                        player.attack();
                        if (player.getHealth() > 0) {
                            System.out.println("You are victorious!");
                            gameBoard[oldCords[0]][oldCords[1]] = "\uD83D\uDFEA";
                        } else {
                            System.out.println("You died in combat");
                            running = false;
                            gameBoard[newCords[0]][newCords[1]] = "\uD83D\uDC79";
                            gameBoard[oldCords[0]][oldCords[1]] = "\uD83D\uDFEA";
                            player.setCords(new int[]{7, 7});
                            player.setHealth(100);
                            player.setStrength(ThreadLocalRandom.current().nextInt(10, 20));
                            goblin.setHealth(30);
                            goblin.setStrength(ThreadLocalRandom.current().nextInt(8, 30));
                            gameBoard[0][0] = "\uD83D\uDD1A";
                            gameBoard[7][7] = "\uD83E\uDDDD";
                        }
                    }
                    if (running) {
                        gameBoard[newCords[0]][newCords[1]] = "\uD83E\uDDDD";
                    }
                }
                if (newCords[0] == 0 && newCords[1] == 0) {
                    System.out.println("You've escaped with you life!");
                    gameBoard[oldCords[0]][oldCords[1]] = "\uD83D\uDFEA";
                    running = false;
                    player.setCords(new int[]{7, 7});
                    player.setHealth(100);
                    goblin.setHealth(30);
                    goblin.setStrength(ThreadLocalRandom.current().nextInt(8, 30));
                    lvl++;
                }
            }
            System.out.println("Would you like to play again? y/n");
            playAgain = playerInput.nextLine();
            

        }while (playAgain.startsWith("y"));
        }
    }

