package me.tjens23.vopcrypto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CaesarCipherTest {

    @Test
    public void testEncrypt() {
        CaesarCipher cipher = new CaesarCipher(3);
        String text = "abc";
        String expected = "def";
        assertEquals(expected, cipher.encrypt(text));
    }

    @Test
    public void testDecrypt() {
        CaesarCipher cipher = new CaesarCipher(3);
        String text = "abc";
        String expected = "def";
        assertEquals(expected, cipher.encrypt(text));
    }
}
