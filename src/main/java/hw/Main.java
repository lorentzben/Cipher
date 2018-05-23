package hw;

import java.util.*;

public class Main {

  public static void main(final String[] args) {

    Scanner keyboard = new Scanner(System.in);

    String response = "";
    {
      System.out.println(
          "Enter C for Ceasarian \n R for Rail-Fence \n S for Straddle Checkerboard \n P for Playfair \n V for Vigenere \n Q to quit: ");
      response = keyboard.nextLine();
      if (response.equalsIgnoreCase("C")) {
        Salad instance = new Salad();
        instance.onStart();
        main(args);
      }
      if (response.equalsIgnoreCase("R")) {
        RailFence rail = new RailFence();
        main(args);
      }
      if (response.equalsIgnoreCase("S")) {
        StraddleChecker straddle = new StraddleChecker();
        straddle.onStart();
        main(args);
      }
      if (response.equalsIgnoreCase("P")) {
        System.out.println("Playfair");
        main(args);
      }
      if (response.equalsIgnoreCase("V")) {
        System.out.println("Vigenere");
        main(args);
      }
    }
    while (!(response.equalsIgnoreCase("Q"))) ;
    System.exit(0);
  }
}
