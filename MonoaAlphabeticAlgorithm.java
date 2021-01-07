import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MonoaAlphabeticAlgorithm {
     static String plaintext;
     static String keys;

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("--------------------------------Starts---------------------------");
          System.out.println("Enter plain text to pass for encryption: ");
          plaintext = sc.nextLine();
          System.out.println("Enter a keys: ");
          keys = sc.nextLine();
          // shuffling............
          String shuffled = shuffle(keys);
          System.out.println(shuffled);
          // functions call..................
          String encryptedText = encryption(plaintext, keys, shuffled);
          System.out.println("Encrypted Text: " + encryptedText);
          System.out.println("Decrypted Text: " + decryption(encryptedText, keys, shuffled));
          sc.close();
     }

     // shuffling........................
     public static String shuffle(String keys) {
          List<String> letters = Arrays.asList(keys.split(""));
          Collections.shuffle(letters);
          String shuffled = "";
          for (String key : letters) {
               shuffled += key;
          }
          return shuffled;
     }

     // decryption
     public static String decryption(String encryptedText, String keys, String shuffled) {
          char decryptedText[] = new char[encryptedText.length()];
          char ch[] = new char[encryptedText.length()];
          char ke[] = new char[keys.length()];
          char sh[] = new char[shuffled.length()];
          for (int i = 0; i < encryptedText.length(); i++) {
               ch[i] = encryptedText.charAt(i);
          }
          for (int j = 0; j < keys.length(); j++) {
               ke[j] = keys.charAt(j);
          }
          for (int k = 0; k < shuffled.length(); k++) {
               sh[k] = shuffled.charAt(k);
          }
          for (int i = 0; i < encryptedText.length(); i++) {
               for (int j = 0; j < keys.length(); j++) {
                    if (sh[j] == encryptedText.charAt(i)) {
                         decryptedText[i] = ke[j];
                         break;
                    }
               }
          }
          return (new String(decryptedText));
     }

     // encryption....................
     public static String encryption(String plaintext, String keys, String shuffled) {
          char encryptedText[] = new char[plaintext.length()];
          char ch[] = new char[plaintext.length()];
          char ke[] = new char[keys.length()];
          char[] sh = new char[shuffled.length()];
          for (int i = 0; i < plaintext.length(); i++) {
               ch[i] = plaintext.charAt(i);
          }
          for (int j = 0; j < keys.length(); j++) {
               ke[j] = keys.charAt(j);
          }
          for (int k = 0; k < shuffled.length(); k++) {
               sh[k] = shuffled.charAt(k);
          }
          for (int i = 0; i < plaintext.length(); i++) {
               for (int j = 0; j < keys.length(); j++) {
                    if (ke[j] == plaintext.charAt(i)) {
                         encryptedText[i] = sh[j];
                         break;
                    }
               }
          }

          return (new String(encryptedText));
     }
}