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
    // String formating ie. lowercase no spaces
    String phrase = input.toLowerCase();
    phrase.replaceAll(" ", "");

    System.out.println("What is the number of rails you want to create?");
    int rails = keyboard.nextInt();

    // stringbuilder to assemble final string
    StringBuilder inProg = new StringBuilder("");
    String result = "";

    // the board array and nessecary variables
    int textLength = phrase.length();
    char[][] board = new char[rails][textLength];
    boolean down = false;
    int count = 0;

    // moves through the matrix and moves up and down based on the position
    for (int i = 0; i < textLength; i++) {

      if (count == 0 || count == (rails - 1)) {
        down = !down;
      }

      board[count][i] = phrase.charAt(i);
      if (down == true) {
        count++;
      } else {
        count--;
      }
    }
    // passed throught the array normally and forms the cipher text
    for (int k = 0; k < rails; k++) {
      for (int l = 0; l < textLength; l++) {
        inProg.append(board[k][l]);
      }
    }

    result = inProg.toString();
    System.out.println("Your result is: " + result);
  }

  public void decrypt() {
    // nessecary parameters from the user
    System.out.println("What is the string you want to decrypt?");
    String input = keyboard.nextLine();
    String phrase = input.toLowerCase();

    System.out.println("What is the number of rails you want to use?");
    int rails = keyboard.nextInt();

    StringBuilder inProgD = new StringBuilder("");
    String result = "";

    int textLength = phrase.length();
    char[][] board = new char[rails][textLength];
    int count = 0;
    boolean down = false;
    int place = 0;

    for (int i = 0; i < textLength; i++) {

      if (count == 0 || count == (rails - 1)) {
        down = !down;
      }
      board[count][i] = '*';
      if (down == true) {
        count++;
      } else {
        count--;
      }
    }

    for (int i = 0; i < rails; i++) {
      for (int j = 0; j < textLength; j++) {
        if (board[i][j] == '*' && place < textLength) {
          board[i][j] = phrase.charAt(place++);
        }
      }
    }

    count = 0;
    down = false;
    for (int i = 0; i < textLength; i++) {

      if (count == 0 || count == (rails - 1)) {
        down = !down;
      }
      inProgD.append(board[count][i]);
      if (down == true) {
        count++;
      } else {
        count--;
      }
    }

    result = inProgD.toString();
    System.out.println("Your result is: " + result);
  }
}
