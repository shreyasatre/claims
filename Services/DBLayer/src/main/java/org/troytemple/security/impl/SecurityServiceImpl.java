package org.troytemple.security.impl;

import org.troytemple.security.SecurityService;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

/**
 * Created by bt_te on 2/28/2016.
 */
public class SecurityServiceImpl implements SecurityService {
    @Override
    public String hash(String plainText, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //byte[] salt = key.getBytes();
        KeySpec spec = new PBEKeySpec(plainText.toCharArray(),salt,655636,128);

        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");

        byte[] hash = skf.generateSecret(spec).getEncoded();

        Base64.Encoder enc = Base64.getEncoder();

        String hashedString = enc.encodeToString(hash);
       // System.out.printf("salt: %s%n", enc.encodeToString(salt));
        //System.out.printf("hash: %s%n", enc.encodeToString(hash));

        return hashedString;
    }

    @Override
    public String encrypt(String plainText, String key) {
        return null;
    }
}
