import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.troytemple.dao.ExpenseTypeRepository;
import org.troytemple.dao.PasswordRepository;
import org.troytemple.dao.model.ExpenseType;

import java.util.List;

/**
 * Created by kdevarajan on 3/9/2016.
 */
@RestController
public class ExpenseController {

    @Autowired
    private ExpenseTypeRepository expenseTypeRepository;

    @RequestMapping(value = "/expenseType",method = RequestMethod.GET)
    public List<ExpenseType> getExpenseTypes(){
        return expenseTypeRepository.getAll();
    }
}
