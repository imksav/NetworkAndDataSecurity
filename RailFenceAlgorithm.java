import java.util.Scanner;

public class RailFenceAlgorithm {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter a message: ");
          String message = sc.nextLine();
          message = message.replaceAll("\\s", "");
          System.out.println("Message: " + message);
          System.out.println("Enter key (Rails Fence value): ");
          int key = sc.nextInt();
          sc.nextLine();
          String encrypt = encryption(message, key);
          System.out.println("Encrypted Message: " + encrypt);
          String decrypt = decryption(encrypt, key);
          System.out.println("Decrypted Message: " + decrypt);
          sc.close();
     }

     // encryption function goes here.............
     static public String encryption(String message, int key) {
          char[][] rails = new char[key][message.length()];
          for (int i = 0; i < key; i++) {
               for (int j = 0; j < message.length(); j++) {
                    rails[i][j] = '.';
               }
          }
          int row = 0;
          int check = 0;
          for (int i = 0; i < message.length(); i++) {
               if (check == 0) {
                    rails[row][i] = message.charAt(i);
                    row++;
                    if (row == key) {
                         check = 1;
                         row--;
                    }
               } else if (check == 1) {
                    row--;
                    rails[row][i] = message.charAt(i);
                    if (row == 0) {
                         check = 0;
                         row = 1;
                    }
               }
          }
          String encryptedText = "";
          for (int i = 0; i < key; i++) {
               for (int j = 0; j < message.length(); j++) {
                    encryptedText += rails[i][j];
               }
          }
          encryptedText = encryptedText.replaceAll("\\.", "");
          return encryptedText;
     }

     // decryption goes here.............
     static public String decryption(String message, int key) {
          // changing the order.............
          int order = 0;
          char[][] rails = new char[key][message.length()];
          for (int i = 0; i < key; i++) {
               for (int j = 0; j < message.length(); j++) {
                    String temp = rails[i][j] + "";
                    if (temp.matches("\\.")) {
                         continue;
                    } else {
                         rails[i][j] = message.charAt(order);
                         order++;
                    }
               }
          }
          String decryptedText = "";
          int check = 0;
          int row = 0;
          // converting into single line
          for (int i = 0; i < message.length(); i++) {
               if (check == 0) {
                    decryptedText += rails[row][i];
                    row++;
                    if (row == key) {
                         check = 1;
                         row--;
                    }
               } else if (check == 1) {
                    row--;
                    decryptedText += rails[row][i];
                    if (row == 0) {
                         check = 0;
                         row = 1;
                    }
               }
          }
          return decryptedText;
     }
}