public class TransactionDriver {
    public static void main(String[] args) {
        Sale sale1 = new Sale("Orange shirt", 14, 15.99, true);
        Sale sale2 = new Sale("Purple pants", 7, 29.99, false);
        System.out.println(sale1);
        System.out.println(sale2);
        System.out.println(String.format("%.2f", sale1.getTotal()));
        System.out.println(String.format("%.2f", sale2.getTotal()));
    }
    

}
