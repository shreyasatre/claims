package org.troytemple.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.troytemple.dao.mapper.GetRecipientMapper;
import org.troytemple.dao.model.Recipient;
import org.troytemple.dao.model.RecipientData;
import org.troytemple.dao.model.tblClaims;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by bt_te on 3/5/2016.
 */
@Repository
public class RecipientRepository {

    private static String INSERT_NEW_RECIPIENT = "insert into TempleClaims.dbo.tblRecipients(strFirstName,strLastName,strAddress,city,state,zip,strNameOnCheck) VALUES (?,?,?,?,?,?,?)";

    private static String GET_RECIPIENT_BY_LAST_NAME = "Select * from TempleClaims.dbo.tblRecipients tr where tr.strLastName like ?;";
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long insert(final RecipientData recipient) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement pst =
                                con.prepareStatement(INSERT_NEW_RECIPIENT,Statement.RETURN_GENERATED_KEYS);
                        pst.setString(1, recipient.getFirstName());
                        pst.setString(2, recipient.getLastName());
                        pst.setString(3, recipient.getAddress());
                        pst.setString(4, recipient.getCity());
                        pst.setString(5, recipient.getState());
                        pst.setString(6, recipient.getZip());
                        pst.setString(7, recipient.getNameOnCheck());


                        return pst;
                    }
                },
                keyHolder);
        return (long) keyHolder.getKey().longValue();
    }


    public Recipient getByLastName(String lastName) {
        try {
            return (Recipient) jdbcTemplate.queryForObject(GET_RECIPIENT_BY_LAST_NAME, new Object[]{lastName}, new GetRecipientMapper());

        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }
}


