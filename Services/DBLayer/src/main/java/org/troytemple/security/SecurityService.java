package org.troytemple.security;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by bt_te on 2/28/2016.
 */
public interface SecurityService {

    String hash(String plainText, byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException;

    String encrypt(String plainText, String key);
}
