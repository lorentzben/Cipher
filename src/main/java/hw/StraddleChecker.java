package hw;

import java.util.*;

public class StraddleChecker {

  char[] alphabet = {
    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
    't', 'u', 'v', 'w', 'x', 'y', 'z'
  };
  HashMap<Character,Integer> alphabetMap = new HashMap<Character,Integer>();
	//TODO add hashmap values for a-z 1-26
	
  Scanner keyboard = new Scanner(System.in);

  Random rand = new Random();

  public void onStart() {
    // makes a list and randomizes it from the alphabet array
    List<Character> alphabetList = new ArrayList<>();
    for (char a : alphabet) {
      alphabetList.add(a);
    }
    Collections.shuffle(alphabetList);
    // generates two random numbers to pick indicies that are left blank in the first row
    int randomOne = rand.nextInt(10) + 0;
    int randomTwo = rand.nextInt(10) + 0;
    // generates the board
    char[][] board = new char[3][10];

    int count = 0;
    Iterator iter = alphabetList.listIterator();
    for (int i = 0; i < 3; i++) {
      System.out.println("First Loop");
      for (int j = 0; j < 10; j++) {
        System.out.println("Second Loop " + j + " " + i);
        if (i == 0 && (j == randomOne || j == randomTwo)) {
          board[i][j] = '*';
        } else {

          char ch = ' ';
          if (!iter.hasNext()) {
            ch = ' ';
          } else {
            ch = iter.next().toString().charAt(0);
          }
          board[i][j] = ch;
        }
      }
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 10; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
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
