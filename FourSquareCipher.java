import java.util.Arrays;
import java.util.Scanner;

public class FourSquareCipher {
    public static void main(String[] args) {
    
    }


private static void decrypt(char[][] plot, String encryptedText) {
        char[] pairs = new char[2];
        String plainText = "";
        String[] pEncryptText = new String[encryptedText.length() / 2];

        int cursor = 0;
        for (int i = 0; i < pEncryptText.length; i++) {
            pEncryptText[i] = "" + encryptedText.charAt(cursor) + encryptedText.charAt(cursor + 1);
            // step by two
            cursor = cursor + 2;
        }

        System.out.println("Pairs: " + Arrays.toString(pEncryptText));

        // O(nk)
        for (int i = 0; i < pEncryptText.length; i++) {
            int column_a = 0;
            int row_a = 0;
            int column_b = 0;
            int row_b = 0;

            // get the pairs
            pairs[0] = pEncryptText[i].charAt(0);
            pairs[1] = pEncryptText[i].charAt(1);

            // find the pairs on key plot 1 NormalAlphabets
            for (int j = 0; j < plot[0].length; j++) {
                // find the first pair to from the normal alphabets
                if(pairs[0] == plot[1][j]) {
                    // the plot is 5 by 25 and we need to find the row, we can convert it to 5x5 (divide 5)
                    row_a = (j / 5) * 5;
                    // to find the column we need to see the remainder, we (mod) it by 5 (j % 5)
                    column_a = j % 5;
                }

                // find the second pair to from the normal alphabets
                if(pairs[1] == plot[2][j]) {
                    row_b = (j / 5) * 5;
                    column_b = j % 5;
                }
            }

            // we need to reverse the column and the row in the two key plot (ciphered plot)
            plainText += plot[0][row_a + column_b]; // find in the key plot 1 Q1
            plainText += plot[0][row_b + column_a];  // find in the key plot 2 Q4
        }

        // show the encrypted text
        System.out.println("Decrypted Text: " + plainText);
    }
    
    
    
    private static void encrypt(char[][] plot, String plainText) {
        char[] pairs = new char[2];
        String encryptedText = "";
        String[] pEncryptText = new String[plainText.length() / 2];

        int cursor = 0;
        for (int i = 0; i < pEncryptText.length; i++) {
            pEncryptText[i] = "" + plainText.charAt(cursor) + plainText.charAt(cursor + 1);
            cursor = cursor + 2;

        }

        System.out.println("Pairs: " + Arrays.toString(pEncryptText));

        for (int i = 0; i < pEncryptText.length; i++) {
            int column_a = 0;
            int row_a = 0;
            int column_b = 0;
            int row_b = 0;

            pairs[0] = pEncryptText[i].charAt(0);
            pairs[1] = pEncryptText[i].charAt(1);

            for (int j = 0; j < plot[0].length; j++) {
                if(pairs[0] == plot[0][j]) {
                    row_a = (j / 5) * 5;
                    column_a = j % 5;
                }

                if(pairs[1] == plot[0][j]) {
                    row_b = (j / 5) * 5;
                    column_b = j % 5;
                }
            }

            encryptedText += plot[1][row_a + column_b]; 
            encryptedText += plot[2][row_b + column_a];  
        }

        System.out.println("Encrypted Text: " + encryptedText);
    }
    
     /**
     * @param plot = plot array max length 25
     * @param remove = char to remove
     */
    private static void plotAlphabets(char[] plot, char remove) {
        int cursor = 0;
        for (int i = 0; i < plot.length; i++) {
            if ((char) ('A' + i) != remove) {
                plot[i] = (char) ('A' + cursor);
            } else {
                cursor++;
                plot[i] = (char) ('A' + cursor);
            }
            cursor++;
        }
    }
     /**
     * @param string string to remove duplicates
     * @return filtered string
     */
    private static String removeDuplicates(String string) {
        char[] characters = string.toCharArray();
        String filterd = "";
        for (int i = 0; i < characters.length; i++) {
            // iterate each char on the list
            boolean isReapeated = false;
            for (int j = 0; j < i; j++) {
                // compare one char (current) to all chars
                if(characters[i] == characters[j]) {
                    isReapeated = true;
                    break;
                }
            }

            if(!isReapeated) { // if the char is not repeated then add to output
                filterd += characters[i];
            }
        }
        return filterd; // sample input: LOLEEOEO, output: LEO
    }
    
    
}
