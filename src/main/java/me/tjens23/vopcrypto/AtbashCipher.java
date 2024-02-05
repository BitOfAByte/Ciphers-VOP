package me.tjens23.vopcrypto;

public class AtbashCipher extends AbstractCipher {

    public AtbashCipher() {
    }

    @Override
    public String encrypt(String text) {
        return atbash(text);
    }

    @Override
    public String decrypt(String text) {
        // Atbash cipher is symmetric, encryption and decryption are the same
        return atbash(text);
    }

    private String atbash(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) ('Z' - (c - 'A')));
            } else if (Character.isLowerCase(c)) {
                result.append((char) ('z' - (c - 'a')));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}