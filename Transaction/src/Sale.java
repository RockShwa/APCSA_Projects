public class Sale extends Transaction {
    private boolean cashOrCredit; // cash = true, credit = false
    private static final double cashDiscount = 0.10;

    public Sale(String description, int items, double cost, boolean cashCredit) {
        super(description, items, cost);
        cashOrCredit = cashCredit;
    }

    public boolean getBoolCashCredit() {
        return cashOrCredit;
    }

// Remeber for percentages, you have to multiply by tax rate/discount and then add/subtract it back to original amount
    @Override
    public double getTotal() {
        double totalCost = this.getItemCost() * this.getNumItems();
        if (cashOrCredit) {
            double itemDiscount = totalCost * cashDiscount;
            totalCost -= itemDiscount;
        }
        double tax = totalCost * Transaction.TAX_RATE;
        return tax + totalCost;
    }

    // Return super.toString in the return statement for it to work
    // Remember scope! A variable declared within an if statement can only be accessed within that if statement
    @Override
    public String toString() {
        String payment = "Cash";
        if (!cashOrCredit) {
            payment = "Credit";
        }
		return super.toString() + "Method of Payment: " + payment + "\n";
    }

    
}
