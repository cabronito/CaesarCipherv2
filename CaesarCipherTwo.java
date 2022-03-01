
/**
 * Encrypt and decrypt a message with Caesar Cipher with two keys of encryption.
 *
 * @author cabronito
 * @version 2022-02-26 v1.0
 */
public class CaesarCipherTwo{
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;

    /**
     * Constructor
     */
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }

    /**
     * encryptTwoKeys returns a String that has been encrypted using the 
     * following algorithm. Parameter key1 is used to encrypt every other 
     * character with the Caesar Cipher algorithm, starting with the first
     * character, and key2 is used to encrypt every other character, 
     * starting with the second character. For example, the call 
     * encryptTwoKeys(“First Legion”, 23, 17) should return 
     *      “Czojq Ivdzle”
     *      
     * Note the ‘F’ is encrypted with key 23, the first ‘i’ with 17, 
     * the ‘r’ with 23, and the ‘s’ with 17, etc. 
     *
     * @param      input
     * @return     encrypted
     */
    public String encrypt (String input) {
        StringBuilder encrypted = new StringBuilder(input);
        char newChar;
        char tempChar = 'a';
        char currentChar;
        int index;
        for (int i = 0; i < encrypted.length(); i++) {
            currentChar = encrypted.charAt(i);
            if (Character.isLowerCase(currentChar)) {
                tempChar = Character.toUpperCase(currentChar);
                index = alphabet.indexOf(tempChar);
            } else {
                index = alphabet.indexOf(currentChar);
            }
            if (index != -1) {
                if (i%2 == 0) {
                    newChar = shiftedAlphabet1.charAt(index);
                } else {
                    newChar = shiftedAlphabet2.charAt(index);
                }
                if (Character.isLowerCase(currentChar)) {
                    if (i%2 == 0) {
                    tempChar = shiftedAlphabet1.charAt(index);
                    } else {
                    tempChar = shiftedAlphabet2.charAt(index);
                    }
                    encrypted.setCharAt(i, Character.toLowerCase(tempChar));
                } else {
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }
    
    /**
     * decrypt returns a String that has been encrypted using the Caesar Cipher 
     * algorithm.
     *
     * @param      input
     * @return     decrypted
     */
    public String decrypt (String input) {
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
        String decrypted = cc.encrypt(input);
        return decrypted;
    }
}
