package org.troytemple.dao.model;

/**
 * Created by bt_te on 3/4/2016.
 */
public class ExpenseType {

    private int expenseTypeId;

    private String expenseCode;

    private String expenseDescription;

    public ExpenseType(int expenseTypeId, String expenseCode, String expenseDescription) {
        this.expenseTypeId = expenseTypeId;
        this.expenseCode = expenseCode;
        this.expenseDescription = expenseDescription;
    }

    public ExpenseType() {
    }

    public int getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(int expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    public String getExpenseCode() {
        return expenseCode;
    }

    public void setExpenseCode(String expenseCode) {
        this.expenseCode = expenseCode;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }
}
