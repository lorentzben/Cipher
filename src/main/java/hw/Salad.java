package hw;

import java.util.*;

public class Salad {
  char[] alphabet = {
    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
    't', 'u', 'v', 'w', 'x', 'y', 'z'
  };
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

    System.out.println("What is the number of letters you want to shift?");
    int shift = keyboard.nextInt();

    StringBuilder inProg = new StringBuilder("");
    String result = "";

    for (char character : phrase.toCharArray()) {
      for (int i = 0; i < alphabet.length; i++) {
        char temp = alphabet[i];
        if (character == temp) {
          int newShift = ((i + shift) % 26);
          inProg.append(alphabet[newShift]);
        } else {
        }
      }
    }
    result = inProg.toString();
    System.out.println("Your modified string is: " + result + "\n");
  }

  public void decrypt() {

    System.out.println("What is the string you want to Decrypt?");
    String input = keyboard.nextLine();
    String phrase = input.toLowerCase();

    System.out.println("What is the number of letters you want to shift?");
    int shift = keyboard.nextInt();

    StringBuilder inProg = new StringBuilder("");
    String result = "";

    for (char character : phrase.toCharArray()) {
      for (int i = 0; i < alphabet.length; i++) {
        char temp = alphabet[i];
        if (character == temp) {
          int newShift = ((i - shift) % 26);
          if (newShift < 0) {
            newShift = 26 + newShift;
          }
          inProg.append(alphabet[newShift]);
        } else {
        }
      }
    }
    result = inProg.toString();
    System.out.println("Your modified string is: " + result + "\n");
  }
}
