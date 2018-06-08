package hw;

import java.util.*;

public class StraddleChecker {

  char[] alphabet = {
    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
    't', 'u', 'v', 'w', 'x', 'y', 'z'
  };
  // Creates the hashmap that is nessecary to keep track of which letter is which val
  HashMap<Character, Integer> alphabetMap = new HashMap<Character, Integer>();
  // generates the board
  char[][] board = new char[3][10];
  char[][] customBoard = new char[3][10];

  Scanner keyboard = new Scanner(System.in);

  Random rand = new Random();

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

    System.out.println("Enter G generated board \n Enter C for custom board");
    input = keyboard.nextLine();
    StringBuilder encryptedText = new StringBuilder("");
    if (input.equalsIgnoreCase("G")) {
      boardGen();
      // Generates the new indexs for the first row
      int rowOne = alphabetMap.get(board[2][6]);
      int rowTwo = alphabetMap.get(board[2][7]);
      for (int i = 0; i < phrase.length(); i++) {
        for (int k = 0; k < 3; k++) {
          for (int l = 0; l < 10; l++) {
            if (phrase.charAt(i) == board[k][l]) {
              if (k == 1) {
                encryptedText.append(rowOne + l + " ");
              } else if (k == 2) {
                encryptedText.append(rowTwo + l + " ");
              } else {
                encryptedText.append(k + l + " ");
              }
            }
          }
        }
      }

    } else if (input.equalsIgnoreCase("C")) {
      custBoard();
      // Generates the new indexs for the first row
      int rowOne = alphabetMap.get(customBoard[2][6]);
      int rowTwo = alphabetMap.get(customBoard[2][7]);
      // encrypts the text by finding the letters in the matrix
      for (int i = 0; i < phrase.length(); i++) {
        for (int k = 0; k < 3; k++) {
          for (int l = 0; l < 10; l++) {
            if (phrase.charAt(i) == customBoard[k][l]) {
              if (k == 1) {
                encryptedText.append(rowOne + l + " ");
              } else if (k == 2) {
                encryptedText.append(rowTwo + l + " ");
              } else {
                encryptedText.append(k + l + " ");
              }
            }
          }
        }
      }

    } else {
      System.out.println("Please try again");
      input = keyboard.nextLine();
    }
    String encrypted = encryptedText.toString();
    System.out.println("Your encrypted String is: " + encrypted);
  }

  public void decrypt() {}

  public void boardGen() {
    for (int i = 0; i < 26; i++) {
      alphabetMap.put(alphabet[i], (i + 1));
    }
    // makes a list and randomizes it from the alphabet array
    List<Character> alphabetList = new ArrayList<>();
    for (char a : alphabet) {
      alphabetList.add(a);
    }
    Collections.shuffle(alphabetList);
    // generates two random numbers to pick indicies that are left blank in the first row
    int randomOne = rand.nextInt(10) + 0;
    int randomTwo = rand.nextInt(10) + 0;
    // ensures that the two numbers are different
    while (randomOne == randomTwo) {
      randomTwo = rand.nextInt(10) + 0;
    }

    int count = 0;
    Iterator iter = alphabetList.listIterator();
    // Fills the board while leaving two blank spaces in the first row
    for (int i = 0; i < 3; i++) {

      for (int j = 0; j < 10; j++) {

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
    // Prints out the full board; needed to decrypt the text
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 10; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }

  public void custBoard() {
    for (int i = 0; i < 26; i++) {
      alphabetMap.put(alphabet[i], (i + 1));
    }
    Scanner keyboard = new Scanner(System.in);
    System.out.println(
        "Enter the custom board \n There are three rows and ten columns \n Enter the rows one line at a time. \n In the first row two * should be used. \n In the third row there are two blank spaces");
    String input = keyboard.nextLine();

    int track = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < input.length(); j++) {
        if (track < 10) {
          customBoard[i][track] = input.charAt(track);
          track++;
        } else {
          System.out.println("That doesn't seem right");
        }
      }
      if (i < 2) {
        System.out.println("Next line");
        input = keyboard.nextLine();
      } else {
        System.out.println();
      }

      track = 0;
    }
    System.out.println("Does this look right?");
    // Prints out the full board; needed to decrypt the text
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 10; j++) {
        System.out.print(customBoard[i][j]);
      }
      System.out.println();
    }
  }
}
