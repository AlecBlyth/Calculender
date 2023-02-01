package ABM.bunnyCorp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.math.BigDecimal;
import java.util.List;

public class moneyAdapter extends ArrayAdapter<Values> {
    public moneyAdapter(@NonNull Context context, List<Values> values) {
        super(context, 0, values);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Values value = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.money_cell, parent, false);
        TextView incomeCellTV = convertView.findViewById(R.id.incomeCellTV);
        TextView billsCellTV = convertView.findViewById(R.id.billsCellTV);
        TextView expensesCellTV = convertView.findViewById(R.id.expensesCellTV);

        Double incomeValue = value.getIncome();
        Double billsValue = value.getBills();
        Double expensesValue = value.getExpenses();

        incomeCellTV.setText("Income: £" + incomeValue);
        billsCellTV.setText("Bills: £" + billsValue);
        expensesCellTV.setText("Expenses: £" + expensesValue);
        System.out.println(value.getSum());
        return convertView;
    }
}
