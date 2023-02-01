package ABM.bunnyCorp;

import java.time.LocalDate;
import java.util.ArrayList;

public class Values {

    public static ArrayList<Values> valuesArrayList = new ArrayList<>();

    public static ArrayList<Values> valuesForDate(LocalDate date){
        ArrayList<Values> vals = new ArrayList<>();
        for(Values values : valuesArrayList){
            if(values.getDate().equals(date))
                vals.add(values);

        }
        return vals;
    }

    public Double getSum(){

        Double sum = 0.00;

        for (Values values : valuesArrayList){
            sum += values.income;
            sum += values.bills;
            sum += values.expenses;
        }
        return sum;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getBills() {
        return bills;
    }

    public void setBills(Double bills) {
        this.bills = bills;
    }

    public Double getExpenses() {
        return expenses;
    }

    public void setExpenses(Double expenses) {
        this.expenses = expenses;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Values(Double income, Double bills, Double expenses, LocalDate date) {
        this.income = income;
        this.bills = bills;
        this.expenses = expenses;
        this.date = date;
    }

    private Double income;
    private Double bills;
    private Double expenses;
    private LocalDate date;


}
