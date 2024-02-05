package me.tjens23.vopcrypto;

public abstract class AbstractCipher implements CipherInterface {
    public int findCharIndex(char ch) {
        for (int i = 0; i < CipherInterface.ALPHABET.length; i++) {
            if (CipherInterface.ALPHABET[i] == ch) {
                return i;
            }
        }
        return -1;
    }
}


