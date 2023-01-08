package BBC;

import java.util.*;

public class Blackjack {

    public static void main(String[] args) {

        Map<String, Integer> deck = new HashMap<String, Integer>();

        deck.put("Ace", 11);
        deck.put("King", 10);
        deck.put("Queen", 10);
        deck.put("Jack", 10);
        deck.put("10", 10);
        deck.put("9", 9);
        deck.put("8", 8);
        deck.put("7", 7);
        deck.put("6", 6);
        deck.put("5", 5);
        deck.put("4", 4);
        deck.put("3", 3);
        deck.put("2", 2);

        //System.out.println(deck.get(pickCard()));
        int card1 = pickCard();
        System.out.println(deck.keySet().toArray()[card1]);
        int value1 = deck.get(deck.keySet().toArray()[card1]);


        int card2 = pickCard();
        System.out.println(deck.keySet().toArray()[card2]);
        int value2 = deck.get(deck.keySet().toArray()[card2]);

        //TOTAL
        int total = value1 + value2;
        if ((value1 == 11 || card2 == 11) && total > 21) {
            if (card1 == 11) {
                value1 = 1;
            } else {
                value2 = 1;
            }
        }
        total = value1 + value2;

        System.out.println("Your total is " + total);

        //HIT or STAND
        boolean play = true;
        while (play && total < 22) {
            Scanner s = new Scanner(System.in);
            System.out.println("Would you like to HIT?");
            String userAns = s.nextLine();

            if (userAns.contains("y")) {
                int card3 = pickCard();
                System.out.println(deck.keySet().toArray()[card3]);
                int value3 = deck.get(deck.keySet().toArray()[card3]);

                total = total + value3;
                System.out.println("Your new total is " + total);
                if (total > 21) {
                    System.out.println("BUST - You lost");
                }
            } else if (userAns.contains("n")) {
                System.out.println("Your score is " + total);
                System.out.println("You have a valid hand of " + total);
                play = false;
            }
        }
    }

    public static int pickCard() {
        Random card = new Random();
        int randomNum = card.nextInt(13);
        return randomNum;
    }
}
