package hw;

import java.util.*;

public class RailFence {

  Scanner keyboard = new Scanner(System.in);

  public void onStart() {

    String response = "";
    {
      System.out.println("Enter E to encrypt \n D to decrypt \n Q to quit: ");
      response = keyboard.nextLine();

      if (response.equalsIgnoreCase("E")) {
        encrypt();
        return;
      }

      if (response.equalsIgnoreCase("D")) {
        decrypt();
        return;
      }
    }
    while (!(response.equalsIgnoreCase("Q"))) ;
  }

  public void encrypt() {

    System.out.println("What is the string you want to encrypt?");
    String input = keyboard.nextLine();
    String phrase = input.toLowerCase();
    phrase.replaceAll(" ", "");

    System.out.println("What is the number of rails you want to create?");
    int rails = keyboard.nextInt();

    StringBuilder inProg = new StringBuilder("");
    String result = "";

    char[] phraseArr = phrase.toCharArray();
    System.out.println(phraseArr);
    for (int r = 0; r < rails; r++) {
      for (int let = 0; let < phraseArr.length; let++) {
        int checkVal = ((2 * rails) - 2);
        if (let % checkVal == 0) {
          System.out.println(let);
          inProg.append(phraseArr[let]);
        }
      }
    }

    result = inProg.toString();
    System.out.println("Your result is: " + result);
  }

  public void decrypt() {
    System.out.println("What is the string you want to decrypt?");
    String input = keyboard.nextLine();
    String phrase = input.toLowerCase();

    System.out.println("What is the number of rails you want to use?");
    int rails = keyboard.nextInt();

    StringBuilder inProg = new StringBuilder("");
    String result = "";

    for (char character : phrase.toCharArray()) {}
  }
}
