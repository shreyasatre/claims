package org.troytemple.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.troytemple.dao.model.ExpenseType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bt_te on 3/4/2016.
 */
@Repository
public class ExpenseTypeRepository {

    private static String GET_EXPENSE_ID = "select * from TempleClaims.dbo.tblExpenseType;";

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ExpenseType> getAll(){

        List<Map<String,Object>> rows = jdbcTemplate.queryForList(GET_EXPENSE_ID);

        List<ExpenseType> expenses = new ArrayList<ExpenseType>();
        for(Map<String,Object> row : rows){
            ExpenseType expenseType = new ExpenseType();
            expenseType.setExpenseTypeId((Integer) row.get("intExpenseTypeIdx"));
            expenseType.setExpenseDescription((String) row.get("strDescription"));
            expenseType.setExpenseCode((String) row.get("strCode"));
            expenses.add(expenseType);
        }

        return expenses;
    }
}
