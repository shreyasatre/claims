package org.troytemple.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.troytemple.dao.RecipientRepository;
import org.troytemple.common.ClaimStatus;
import org.troytemple.dao.ExpenseTypeRepository;
import org.troytemple.dao.UserRepository;
import org.troytemple.dao.model.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * Created by bt_te on 3/4/2016.
 */
public class SubmitClaimsTransformer implements ITransformer<SubmitClaimRequest, tblClaims> {

    @Autowired
    private ExpenseTypeRepository expenseTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    private List<ExpenseType> expenses;

    @Override
    public tblClaims transform(SubmitClaimRequest request) {

        ClaimsData claimsData = request.getClaimsData();
        RecipientData recipientData = request.getRecipientData();
        tblClaims claims = null;
        int expenseTypeId = getExpenseId(claimsData.getExpenseType());
        tblUsers user = userRepository.getUserDetails(claimsData.getUsername());
        if (expenseTypeId != -1) {
            claims = new tblClaims();
            claims.setIntLnkClaimsStatus(ClaimStatus.SUBMITTED.getStatus());
            claims.setIntLnkExpenseTypeIdx(expenseTypeId);
            claims.setIntLnkUserIdx(Integer.parseInt((user.getIntUserIdx())));
            claims.setDecPrice(Double.parseDouble(claimsData.getPrice()));
            claims.setIntLnkCommitteeIdx(user.getIntCommitteeId());
            claims.setDtmUploadDate(getCurrentTime());
            claims.setStrImagePath(claimsData.getImagePath());
            claims.setStrDescription(claimsData.getDescription());

            claims.setIntLnkRecipientIdx(getRecipientId(recipientData));
        }
        return claims;
    }

    private int getRecipientId(RecipientData recipientData) {

       Recipient recipient =  recipientRepository.getByLastName(recipientData.getLastName());
        if(recipient == null){
            return (int) recipientRepository.insert(recipientData);
        }

        return recipient.getIntRecipientId();
    }

    private int getExpenseId(String expenseString) {
        List<ExpenseType> expenses = expenseTypeRepository.getAll();

        for (ExpenseType expenseType : expenses) {
            if (expenseString.equals(expenseType.getExpenseDescription())) {
                return expenseType.getExpenseTypeId();
            }
        }

        return -1;
    }

    private Timestamp getCurrentTime() {
        long timeNow = Calendar.getInstance().getTimeInMillis();
        return new java.sql.Timestamp(timeNow);
    }
}
