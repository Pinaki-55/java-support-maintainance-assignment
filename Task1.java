import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task1 {

    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {

      List<LoanAccount> result = new ArrayList<>();

      if (accounts == null) {
            return result;
        }

        for (LoanAccount account : accounts) {

            if (account.getDueDate() != null &&
                    account.getDueDate().before(new Date())) {

                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }

        return result;
    }
}
