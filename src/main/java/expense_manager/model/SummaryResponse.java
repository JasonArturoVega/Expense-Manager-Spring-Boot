package expense_manager.model;

public class SummaryResponse {

    public SummaryResponse(int currentAmount, int currentIncome, int currentExpense)
    {
        this.currentAmount = currentAmount;
        this.currentIncome = currentIncome;
        this.currentExpense = currentExpense;
    }

    private int currentAmount;
    private int currentIncome;
    private int currentExpense;

    public int getCurrentAmount() {
        return currentAmount;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public int getCurrentExpense() {
        return currentExpense;
    }
}
