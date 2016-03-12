package org.troytemple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.troytemple.common.RolesEnum;
import org.troytemple.dao.ClaimsRepository;
import org.troytemple.dao.model.*;
import org.troytemple.transformer.ITransformer;

import javax.servlet.http.HttpSession;

/**
 * Created by bt_te on 2/17/2016.
 */
@RestController
@RequestMapping("/claims")
public class ClaimsController {

    @Autowired
    private ClaimsRepository claimsRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private ITransformer<SubmitClaimRequest,tblClaims> submitClaimsTransformer;

    @RequestMapping(value = "/submit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void submitClaims(@RequestBody SubmitClaimRequest submitClaimRequest) {
        claimsRepository.insert(submitClaimsTransformer.transform(submitClaimRequest));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public GetClaimsResponse getClaims(@RequestHeader("username") String userName) {

        if (httpSession.getAttribute("role") != null) {
            String role = (String) httpSession.getAttribute("role");
            if (role != null && role.equals(RolesEnum.APPROVER.getRole())) {
                return claimsRepository.get(userName, role);
            } else if (role.equals(RolesEnum.SUBMITTER.getRole())) {
                return claimsRepository.get(userName);
            }
        }
        return null;
    }

    public ClaimsRepository getClaimsRepository() {
        return claimsRepository;
    }

    public void setClaimsRepository(ClaimsRepository claimsRepository) {
        this.claimsRepository = claimsRepository;
    }

    public HttpSession getHttpSession() {
        return httpSession;
    }

    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public ITransformer<SubmitClaimRequest, tblClaims> getSubmitClaimsTransformer() {
        return submitClaimsTransformer;
    }

    public void setSubmitClaimsTransformer(ITransformer<SubmitClaimRequest, tblClaims> submitClaimsTransformer) {
        this.submitClaimsTransformer = submitClaimsTransformer;
    }
}
