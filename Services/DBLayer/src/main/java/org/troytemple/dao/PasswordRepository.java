package org.troytemple.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.troytemple.dao.mapper.CustomPasswordRowMapper;
import org.troytemple.dao.model.Claim;
import org.troytemple.dao.model.GetClaimsResponse;
import org.troytemple.dao.model.tblPassword;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bt_te on 2/28/2016.
 */
@Repository
public class PasswordRepository {

    private String GET_PASSWORD_FOR_USERNAME = "select tp.strPassword,tp.strStatus,tp.intInvalidAttempts from TempleClaims.dbo.tblPassword tp, TempleClaims.dbo.tblUserPasswords tup,TempleClaims.dbo.tblUsers tu where tp.intIdx=tup.intLnkPasswordIdx and tup.intLnkUserIdx=tu.intUserIdx and tu.strUsername like ?";

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public tblPassword get(String userName) {
         return (tblPassword) jdbcTemplate.queryForObject(GET_PASSWORD_FOR_USERNAME,new Object[]{userName},new CustomPasswordRowMapper());
    }

}
