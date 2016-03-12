package org.troytemple.service.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.troytemple.dao.model.tblPassword;
import org.troytemple.dao.model.tblUsers;
import org.troytemple.security.impl.SecurityServiceImpl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by bt_te on 2/28/2016.
 */
public class AuthenticationImpl {

    @Autowired
    private SecurityServiceImpl securityServiceImpl;

    public boolean authenticate(tblUsers users, tblPassword password, String inputUsername, String inputPassword) throws InvalidKeySpecException, NoSuchAlgorithmException {

        String hashedInput = securityServiceImpl.hash(inputPassword,users.getSalt().getBytes());

        if(users != null && password != null){
            if(users.getStrUsername().equals(inputUsername) && password.getPassword().equals(hashedInput)){
                return true;
            }
        }

        return false;
    }
}
