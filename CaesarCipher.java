
/**
 * CaesarCipher encrypt and decrypt message from a file using the duke library
 *
 * @author cabronito
 * @version 2022-02-25
 */
public class CaesarCipher {
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;

    /**
     * Object constructor of CaesarCipher's class
     */
    public CaesarCipher(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) 
                            + alphabet.substring(0, key);
        mainKey = key;
    }

    /**
     * encrypt returns a String that has been encrypted using the Caesar Cipher 
     * algorithm. Assume that all the alphabetic characters are uppercase 
     * letters. For example, the call
     *      encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23)
     * 
     * should return the string 
     *      “CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”
     *
     * @param      input, key
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
                newChar = shiftedAlphabet.charAt(index);
                if (Character.isLowerCase(currentChar)) {
                    tempChar = shiftedAlphabet.charAt(index);
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
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        String decrypted = cc.encrypt(input);
        return decrypted;
    }
}
