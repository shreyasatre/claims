package org.troytemple.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.troytemple.dao.model.tblPassword;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bt_te on 2/28/2016.
 */
public class CustomPasswordRowMapper implements RowMapper {
    @Override
    public tblPassword mapRow(ResultSet resultSet, int i) throws SQLException {

        tblPassword password = new tblPassword();

        password.setPassword(resultSet.getString("strPassword"));
        password.setStatus(resultSet.getString("strStatus"));
        password.setInvalidAttempts(resultSet.getInt("intInvalidAttempts"));
        return password;
    }
}
