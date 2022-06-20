package com.domain.converter;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;

public class StringAttributeConverter implements AttributeConverter<String, String>{

    private static final String AES = "AES";
    private static final byte[] encryptionKey = "this-is-test-key".getBytes();

    private final Cipher encryptCipher;
    private final Cipher decryptCipher;

    public StringAttributeConverter() {
        try {
            Key key = new SecretKeySpec(encryptionKey, AES);
            encryptCipher = Cipher.getInstance(AES);
            encryptCipher.init(Cipher.ENCRYPT_MODE, key);
            decryptCipher = Cipher.getInstance(AES);
            decryptCipher.init(Cipher.DECRYPT_MODE, key);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {
            return Base64.getEncoder().encodeToString(encryptCipher.doFinal(attribute.getBytes()));
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        try {
            return new String(decryptCipher.doFinal(Base64.getDecoder().decode(dbData)));
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    
}
