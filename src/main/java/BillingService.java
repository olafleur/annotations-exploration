/**
 * Created by olivierlafleur on 2016-01-27.
 */
public class BillingService {
    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;

    BillingService(CreditCardProcessor processor,
                   TransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    public boolean chargeOrder() {
        //Use the two classes
        return true;
    }
}
