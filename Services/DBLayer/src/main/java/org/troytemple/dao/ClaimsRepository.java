package org.troytemple.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.troytemple.dao.model.Claim;
import org.troytemple.dao.model.GetClaimsResponse;
import org.troytemple.dao.model.tblClaims;
import org.troytemple.dao.model.tblUsers;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bt_te on 2/17/2016.
 */
@Repository
public class ClaimsRepository {

    private static final String INSERT_CLAIMS_DATA = "insert into TempleClaims.dbo.tblClaims (intLnkUserIdx,intLnkExpenseTypeIdx,decPrice,strImagePath,intLnkClaimsStatus,dtmUploadDate,intLnkCommitteeIdx,intLnkRecipientIdx,strDescription) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String RETRIEVE_CLAIMS_DATA_FOR_USER = "Select tu.strUsername,tcst.strStatusName,tc.decPrice,tc.strDescription,te.strDescription as \"expenseType\",tcm.strName,tc.dtmUploadDate from TempleClaims.dbo.tblClaims tc,TempleClaims.dbo.tblUsers tu, TempleClaims.dbo.tblExpenseType te, TempleClaims.dbo.tblCommittees tcm,TempleClaims.dbo.tblClaimsStatus tcst where tu.intUserIdx=tc.intLnkUserIdx and te.intExpenseTypeIdx=tc.intLnkExpenseTypeIdx and tcm.intIdx=tc.intLnkCommitteeIdx and tcst.intClaimsStatusIdx=tc.intLnkClaimsStatus and tcst.strStatusName like 'SUBMITTED' and tu.strUsername like ?;";


    private static final String RETRIEVE_CLAIMS_DATA_FOR_APPROVER = "Select tu.strUsername,tcst.strStatusName,tc.decPrice,tc.strDescription,te.strDescription as \"expenseType\"\n" +
            ",tcm.strName,tc.dtmUploadDate from TempleClaims.dbo.tblClaims tc, TempleClaims.dbo.tblUsers tu,\n" +
            " TempleClaims.dbo.tblExpenseType te, TempleClaims.dbo.tblCommittees tcm,TempleClaims.dbo.tblClaimsStatus tcst \n" +
            " where tu.intUserIdx=tc.intLnkUserIdx and te.intExpenseTypeIdx=tc.intLnkExpenseTypeIdx \n" +
            " and tcm.intIdx=tc.intLnkCommitteeIdx and tcst.intClaimsStatusIdx=tc.intLnkClaimsStatus and tcst.strStatusName like 'SUBMITTED' \n" +
            " ";

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(tblClaims claimsData) {
        try {
            jdbcTemplate.update(INSERT_CLAIMS_DATA, new Object[]{claimsData.getIntLnkUserIdx(), claimsData.getIntLnkExpenseTypeIdx(), claimsData.getDecPrice(), claimsData.getStrImagePath(), claimsData.getIntLnkClaimsStatus(), claimsData.getDtmUploadDate(), claimsData.getIntLnkCommitteeIdx(), claimsData.getIntLnkRecipientIdx(), claimsData.getStrDescription()});
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public GetClaimsResponse get(String userName) {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(RETRIEVE_CLAIMS_DATA_FOR_USER,userName);

        List<Claim> claims = new ArrayList<Claim>();
        for(Map<String,Object> row : rows){
            Claim claim  = new Claim();
            claim.setUserName((String) row.get("strUsername"));
            claim.setCommittee((String) row.get("strName"));
            claim.setDescription((String) row.get("strDescription"));
            claim.setExpenseType((String) row.get("expenseType"));
            claim.setStatus((String) row.get("strStatusName"));
            claim.setSubmittedDate(formatTimeStamp((Timestamp) row.get("dtmUploadDate")));
            claim.setPrice((Double)row.get("decPrice"));

            claims.add(claim);
        }
        return new GetClaimsResponse(claims);
    }

    public GetClaimsResponse get(String userName,String role) {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(RETRIEVE_CLAIMS_DATA_FOR_APPROVER);

        List<Claim> claims = new ArrayList<Claim>();
        for(Map<String,Object> row : rows){
            Claim claim  = new Claim();
            claim.setUserName((String) row.get("strUsername"));
            claim.setCommittee((String) row.get("strName"));
            claim.setDescription((String) row.get("strDescription"));
            claim.setExpenseType((String) row.get("expenseType"));
            claim.setStatus((String) row.get("strStatusName"));
            claim.setSubmittedDate(formatTimeStamp((Timestamp) row.get("dtmUploadDate")));
            claim.setPrice((Double)row.get("decPrice"));

            claims.add(claim);
        }
        return new GetClaimsResponse(claims);
    }

    private String formatTimeStamp(Timestamp timestamp) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        return String.valueOf(format.format(timestamp));
    }
}
