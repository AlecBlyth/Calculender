package ABM.bunnyCorp;

import static ABM.bunnyCorp.CalenderUtils.selectedDate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class moneyActivity extends AppCompatActivity {

    private EditText txtIncome, txtBills, txtExpenses;
    private TextView moneyDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        initWidgets();
        moneyDate.setText("Date: " + CalenderUtils.formattedDate(selectedDate));
    }

    private void initWidgets() {

        txtIncome = findViewById(R.id.txtIncome);
        txtBills = findViewById(R.id.txtBills);
        txtExpenses = findViewById(R.id.txtExpenses);
        moneyDate = findViewById(R.id.moneyDateTV);

    }

    public void saveMoneyAction(View view) {
        Double income = Double.valueOf(String.valueOf(txtIncome.getText()));
        Double bills = Double.valueOf(String.valueOf(txtBills.getText()));
        Double expenses = Double.valueOf(String.valueOf(txtExpenses.getText()));
        Values newValue = new Values(income, -bills, -expenses, selectedDate);
        Values.valuesArrayList.add(newValue);
        Intent intent = new Intent(moneyActivity.this, MainActivity.class);
        intent.putExtra("test", Values.valuesArrayList);
        finish();
    }
}