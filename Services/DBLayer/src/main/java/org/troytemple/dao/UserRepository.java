package org.troytemple.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.troytemple.dao.mapper.GetUsersRowMapper;
import org.troytemple.dao.model.tblUsers;

/**
 * Created by bt_te on 2/2/2016.
 */
@Repository
public class UserRepository {
    private static final String GET_USER_DETAILS = "Select tu.intUserIdx,tu.strMembershipID,tu.strName,tu.strAddress,tu.intLnkAccountStatus,tu.intCommitteeIdx,tur.strRoleName,tu.strUsername,tu.strSalt from TempleClaims.dbo.tblUsers tu, TempleClaims.dbo.tblUserRoles tur where tu.intLnkUserRole=tur.intRoleIdx and tu.strUsername=?;";
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public tblUsers getUserDetails(String strUsername) {

        return (tblUsers) jdbcTemplate.queryForObject(GET_USER_DETAILS,new Object[]{strUsername},new GetUsersRowMapper());
    }
}
