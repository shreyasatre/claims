package org.troytemple.dao.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.troytemple.dao.model.DBSqlConnection;

import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by bt_te on 2/2/2016.
 */
public class DBUtil {

    @Autowired
    private Properties myProperties;

    public DBSqlConnection loadSqlProperties(){
       return new DBSqlConnection(myProperties.get("forName").toString(),myProperties.get("windowsAuthString").toString());
    }
}
