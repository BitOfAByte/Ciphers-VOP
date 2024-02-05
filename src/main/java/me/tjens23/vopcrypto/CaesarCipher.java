package me.tjens23.vopcrypto;

public class CaesarCipher extends AbstractCipher {
    int rotFactor;

    public CaesarCipher(int rotFactor) {
        this.rotFactor = rotFactor % 26;
    }

    @Override
    public String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                result.append((char) ((character - base + rotFactor) % 26 + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                result.append((char) ((character - base - rotFactor + 26) % 26 + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
