package org.troytemple.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.troytemple.dao.model.tblUsers;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bt_te on 3/1/2016.
 */
public class GetUsersRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        tblUsers users = new tblUsers();
        users.setIntUserIdx(resultSet.getString("intUserIdx"));
        users.setStrMembershipID(resultSet.getString("strMembershipID"));
        users.setStrName(resultSet.getString("strName"));
        users.setStrAddress(resultSet.getString("strAddress"));
        users.setIntLnkAccountStatus(resultSet.getInt("intLnkAccountStatus"));
        users.setStrRole(resultSet.getString("strRoleName"));
        users.setStrUsername(resultSet.getString("strUsername"));
        users.setSalt(resultSet.getString("strSalt"));
        users.setIntCommitteeId(resultSet.getInt("intCommitteeIdx"));


        return users;
    }
}
