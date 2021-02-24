public class PlayFair {
     private String keyword = new String();
     private String key = new String();
     private char matrix_arr[][] = new char[5][5];

     public void setKey(String k) {
          keyword = k;
     }

     public void keyGen() {
          boolean flag = true;
          char current;

          key = keyword;

          for (int i = 0; i < 26; i++) {
               current = (char) (i + 97);

               if (current == 'j')
                    continue;

               for (int j = 0; j < keyword.length(); j++) {
                    if (current == keyword.charAt(j)) {
                         flag = false;
                         break;
                    }
               }

               if (flag)
                    key = key + current;

               flag = true;
          }

          System.out.println(key);
          matrix();

     }

     private void matrix() {
          int counter = 0;

          for (int i = 0; i < 5; i++) {
               for (int j = 0; j < 5; j++) {
                    matrix_arr[i][j] = key.charAt(counter);
                    System.out.printf("%s ", matrix_arr[i][j]);

                    counter++;
               }

               System.out.println("\n");
          }
     }

     private String[] divideTwoPairs(String original) {
          int size = original.length();

          if (size % 2 != 0)
               size++;

          String x[] = new String[size / 2];

          int counter = 0;

          for (int i = 0; i < size / 2; i++) {
               x[i] = original.substring(counter, counter + 2);
               System.out.println(x[i]);
               counter = counter + 2;
          }

          return x;
     }

     public int[] getDimension(char letter) {
          int[] key = new int[2];

          if (letter == 'j')
               letter = 'i';

          for (int i = 0; i < 5; i++) {
               for (int j = 0; j < 5; j++) {
                    if (matrix_arr[i][j] == letter) {
                         key[0] = i;
                         key[1] = j;
                         break;
                    }
               }

          }

          return key;
     }

     public String encrypt(String Source) {
          String src_arr[] = divideTwoPairs(Source);

          String Code = new String();

          char one;
          char two;

          int part1[] = new int[2];
          int part2[] = new int[2];

          // start on pair by pair
          for (int i = 0; i < src_arr.length; i++) {
               one = src_arr[i].charAt(0);// get first char
               two = src_arr[i].charAt(1);// get second char

               part1 = getDimension(one);// get position of the first char
               part2 = getDimension(two);// get position of the second char

               // check for specail casese
               if (part1[0] == part2[0])// same row
               {
                    if (part1[1] < 4)
                         part1[1]++;

                    else
                         part1[1] = 0;

                    if (part2[1] < 4)
                         part2[1]++;

                    else
                         part2[1] = 0;

               }

               else if (part1[1] == part2[1]) // same column
               {
                    if (part1[0] < 4)
                         part1[0]++;

                    else
                         part1[0] = 0;

                    if (part2[0] < 4)
                         part2[0]++;

                    else
                         part2[0] = 0;
               }

               else {
                    int temp = part1[1];
                    part1[1] = part2[1];
                    part2[1] = temp;
               }

               Code = Code + matrix_arr[part1[0]][part1[1]] + matrix_arr[part2[0]][part2[1]];
          }
          System.out.println(Code);
          return Code;
     }

     public String decrypt(String Code) {
          String original = new String();

          String src_arr[] = divideTwoPairs(Code);

          char one;
          char two;

          int part1[] = new int[2];
          int part2[] = new int[2];

          // start on pair by pair
          for (int i = 0; i <= src_arr.length; i++) {
               one = src_arr[i].charAt(0);// get first char
               two = src_arr[i].charAt(1);// get second char

               part1 = getDimension(one);// get position of the first char
               part2 = getDimension(two);// get position of the second char

               // check for specail casese
               if (part1[0] == part2[0])// same row
               {
                    if (part1[1] > 0)
                         part1[1]--;

                    else
                         part1[1] = 4;

                    if (part2[1] > 0)
                         part2[1]--;

                    else
                         part2[1] = 4;

               }

               else if (part1[1] == part2[1]) // same column
               {
                    if (part1[0] > 0)
                         part1[0]--;

                    else
                         part1[0] = 4;

                    if (part2[0] > 0)
                         part2[0]--;

                    else
                         part2[0] = 4;
               }

               else {
                    int temp = part1[1];
                    part1[1] = part2[1];
                    part2[1] = temp;
               }

               original = original + matrix_arr[part1[0]][part1[1]] + matrix_arr[part2[0]][part2[1]];
          }

          System.out.println(original);
          return original;
     }

     public static void main(String[] args) {
          System.out.println("Enter message: ");
          String source = "Hello";
          PlayFair p1 = new PlayFair();
          p1.encrypt(source);
     }
}