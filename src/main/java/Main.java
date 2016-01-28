/**
 * Created by olivierlafleur on 2016-01-27.
 */
public class Main {
    public static void main(String[] args) {
        BillingService billingService = new BillingService(new PaypalProcessor(), new DatabaseLog());

        billingService.chargeOrder();
    }
}
