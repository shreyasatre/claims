package org.troytemple.security.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.util.StringJoiner;
import org.mockito.runners.MockitoJUnitRunner;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.UUID;

/**
 * Created by bt_te on 2/28/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class SecurityServiceImplTest {

    private SecurityServiceImpl securityServiceImpl = new SecurityServiceImpl();
    private SecureRandom random = new SecureRandom();

    @Test
    public void testHash() throws InvalidKeySpecException, NoSuchAlgorithmException {

        String seed = UUID.randomUUID().toString();
        System.out.println(seed);
        System.out.println(securityServiceImpl.hash("app1234",seed.getBytes()));
    }
}
