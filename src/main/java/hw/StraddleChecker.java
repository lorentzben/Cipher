package hw;

import java.util.*;

public class StraddleChecker {

  String[] alphabet = {
    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
    "t", "u", "v", "w", "x", "y", "z"
  };
  Scanner keyboard = new Scanner(System.in);

  Random rand = new Random();

  public void onStart() {
    List<String> alphabetList = new ArrayList<>();
    for (String a : alphabet) {
      alphabetList.add(a);
    }
    Collections.shuffle(alphabetList);
    int randomOne = rand.nextInt(10) + 0;
    int randomTwo = rand.nextInt(10) + 0;
    String[][] board = new String[9][2];
    Queue<String> alphaQueue = new LinkedList<String>();
    for (String letter : alphabetList) {
      alphaQueue.offer(letter);
    }

    for (int i = 0; i < 2; i++) {
      for (int j = 0; i < 9; j++) {
        for (String let : alphabetList) {
          if ((i == 0) && ((j == randomOne) || (j == randomTwo))) {
            board[i][j] = "";
          } else {
            board[i][j] = alphaQueue.poll();
          }
        }
      }
    }

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.print(board[i][j]);
        System.out.println();
      }
    }

    for (String str : alphabetList) {
      System.out.println(str);
    }
    System.out.println(randomOne + " " + randomTwo);

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

  public void encrypt() {}

  public void decrypt() {}
}
