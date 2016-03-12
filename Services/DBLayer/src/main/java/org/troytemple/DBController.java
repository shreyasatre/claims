package org.troytemple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.troytemple.dao.PasswordRepository;
import org.troytemple.dao.UserRepository;
import org.troytemple.dao.model.GetSessionResponse;
import org.troytemple.dao.model.LoginRequest;
import org.troytemple.dao.model.tblPassword;
import org.troytemple.dao.model.tblUsers;
import org.troytemple.service.authentication.AuthenticationImpl;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by bt_te on 1/17/2016.
 */
@RestController
public class DBController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private AuthenticationImpl authenticationImpl;

    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public tblUsers dbConnection(@RequestBody LoginRequest loginRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {
        tblUsers user = null;
        tblPassword password = null;

        user = userRepository.getUserDetails(loginRequest.getUsername());
        password = passwordRepository.get(loginRequest.getUsername());


        if(authenticationImpl.authenticate(user,password,loginRequest.getUsername(),loginRequest.getPassword())){
            httpSession.setAttribute("isLoggedIn","true");
            httpSession.setAttribute("role",user.getStrRole());
            httpSession.setAttribute("username",user.getStrUsername());

            return user;
        }
        else{
            user.setIntLnkAccountStatus(0);
            return user;
        }
        //return userDAOImpl.getUserDetails();
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public void logout() throws InvalidKeySpecException, NoSuchAlgorithmException {
        httpSession.invalidate();
    }

    @RequestMapping(value = "/session",method = RequestMethod.GET)
    @ResponseBody
    public GetSessionResponse session() throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (httpSession.getAttribute("isLoggedIn") != null) {

            return new GetSessionResponse((String) httpSession.getAttribute("isLoggedIn"),(String) httpSession.getAttribute("username") );
        }

        return new GetSessionResponse("false","null");
    }
}
