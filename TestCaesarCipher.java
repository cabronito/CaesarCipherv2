
/**
 * testing the class CaesarCipher
 *
 * @author cabronito
 * @version 2022-02-25 v1.0
 */

import edu.duke.*;

public class TestCaesarCipher
{
    /**
     * count the frequences of each letter to recognize if it's an english 
     * message
     *
     * @param      message
     * @return     counts[]
     */
    private int[] countLetters (String message) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                counts[index]++;
            }
        }
        return counts;
    }
    
    /**
     * return the maxIndexOf an array.
     *
     * @param      frequences[]
     * @return     maxIndex
     */
    private int maxIndexOf(int[] frequences) {
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < frequences.length; i++) {
            if (frequences[i] > maxValue) {
                maxIndex = i;
                maxValue = frequences[i];
            }
        }
        return maxIndex;
    }
    
    /**
     * test the encrypt and decrypt method in CaesarCipher's class
     * 
     * @param       none
     * @return      none
     */
    public void simpleTest () {
        /*FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println("Original message is : " + message);
        CaesarCipher cc = new CaesarCipher(18);
        message = cc.encrypt(message);
        System.out.println("Encrypted message is : " + message);
        message = cc.decrypt(message);
        System.out.println("And decrypted message is : " + message);
        message = cc.encrypt(message);
        System.out.println("Re-encryption of the message");
        int key = breakCaesarCipher(message);
        System.out.println("key is: " + key);
        cc = new CaesarCipher(key);
        message = cc.decrypt(message);
        System.out.println("And decrypted message is : " + message);*/
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        CaesarCipher cc = new CaesarCipher(15);
        message = cc.encrypt(message);
        System.out.println("Encrypted message is : " + message);
    }
    
    /**
     * this method shouldd figure out which key was used to encrypted the
     * input
     * 
     * @param       input
     * @return      key
     */
    private int breakCaesarCipher (String input) {
        int key = 0;
        int[] frequences = countLetters(input);
        int maxIndex = maxIndexOf(frequences);
        key = maxIndex - 4;
        if (maxIndex < 4) {
            key = 26 - (4 - maxIndex);
        }
        return key;
    }
}
