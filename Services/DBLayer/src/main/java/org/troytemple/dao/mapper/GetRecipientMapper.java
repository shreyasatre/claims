package org.troytemple.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.troytemple.dao.model.Recipient;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bt_te on 3/5/2016.
 */
public class GetRecipientMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Recipient recipient = new Recipient();

        recipient.setIntRecipientId(resultSet.getInt("intRecipientIdx"));
        recipient.setFirstName(resultSet.getString("strFirstName"));
        recipient.setLastName(resultSet.getString("strLastName"));
        recipient.setAddress(resultSet.getString("strAddress"));
        recipient.setCity(resultSet.getString("city"));
        recipient.setState(resultSet.getString("state"));
        recipient.setZip(resultSet.getString("zip"));

        return recipient;
    }
}
