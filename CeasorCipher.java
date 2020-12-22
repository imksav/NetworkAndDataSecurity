import java.util.Scanner;

class CeasorCipher {
    public static void main(String[] args) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890 !@#$%^&*()_+";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plaintext:");
        String plaintext = sc.nextLine();
        System.out.println("Enter shift key:");
        int key = sc.nextInt();
        String encrypt = encryption(plaintext, key, letters);
        System.out.println("Encrypted: " + encrypt);
        String dencrypt = decryption(encrypt, key, letters);
        System.out.println("Encrypted: " + dencrypt);
        sc.close();
    }

    static String encryption(String plaintext, int key, String letters) {
        String ciphertext = "";
        // plaintext = plaintext.toUpperCase();
        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            int ch = letters.indexOf(plainChar);

            ciphertext += (char) (letters.charAt((ch + key) % letters.length()));
        }
        return ciphertext;
    }

    static String decryption(String ciphertext, int key, String letters) {
        // ciphertext = ciphertext.toUpperCase();
        String plaintext = "";
        for (int i = 0; i < ciphertext.length(); i++) {
            int ch = letters.indexOf(ciphertext.charAt(i));
            plaintext += (char) (letters.charAt((ch - key) % letters.length()));
        }
        return plaintext;
    }
}