
/**
 * class for testing CaesarCipherTwo's class
 *
 * @author cabronito
 * @version 2022-02-26 v1.0
 */

import edu.duke.*;

public class TestCaesarCipherTwo
{
    private int key1;
    private int key2;
    
    /**
     * constructor of TestCaesarCipherTwo
     */
    public TestCaesarCipherTwo() {}

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
     *  halfOfString return a new String that is every other character from 
     *  message starting with the start position. For example, the call 
     *  halfOfString(“Qbkm Zgis”, 0) returns the String “Qk gs” and the call
     *  halfOfString(“Qbkm Zgis”, 1) returns the String “bmZi”
     *
     * @param      message, start
     * @return     halfString
     */
    private String halfOfString(String message, int start) {
        String halfOfString = "";
        for (int i = start; i < message.length(); i += 2) {
            halfOfString += message.charAt(i);
        }
        return halfOfString;
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

    
    public void simpleTests () {
        FileResource fr = new FileResource();
        String message = fr.asString();
        /*String crypted = "";
        String decrypted = "";
        CaesarCipherTwo cc = new CaesarCipherTwo(17, 3);
        crypted = cc.encrypt(message);
        System.out.println("Original message is: " + message);
        System.out.println("Encrypt message is: " + crypted);
        decrypted = cc.decrypt(crypted);
        System.out.println("And now, this is decrypted: " + decrypted);
        String cryptedHalfPart1 = halfOfString(crypted, 0);
        String cryptedHalfPart2 = halfOfString(crypted, 1);
        key1 = breakCaesarCipher(cryptedHalfPart1);
        key2 = breakCaesarCipher(cryptedHalfPart2);
        CaesarCipherTwo cc2 = new CaesarCipherTwo(key1, key2);
        decrypted = cc2.decrypt(crypted);
        System.out.println("With caesar breaker the message is: " + decrypted);*/
        String cryptedHalfPart1 = halfOfString(message, 0);
        String cryptedHalfPart2 = halfOfString(message, 1);
        key1 = breakCaesarCipher(cryptedHalfPart1);
        key2 = breakCaesarCipher(cryptedHalfPart2);
        System.out.println(key1 + ", " + key2);
        CaesarCipherTwo cc2 = new CaesarCipherTwo(key1, key2);
        message = cc2.decrypt(message);
        System.out.println("Decrypted message is : " + message);
    }
}
