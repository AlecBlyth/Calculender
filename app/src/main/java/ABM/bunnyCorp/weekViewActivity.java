package ABM.bunnyCorp;

import static ABM.bunnyCorp.CalenderUtils.dayMonthYearFromDate;
import static ABM.bunnyCorp.CalenderUtils.daysInWeekArray;
import static ABM.bunnyCorp.CalenderUtils.selectedDate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;

public class weekViewActivity extends AppCompatActivity implements CalenderAdapter.OnItemListener {

    private TextView monthlyText;
    private RecyclerView calendarRecyclerView;
    private ListView moneyListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);
        initWidgets();
        setWeekView();
    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calenderRecyclerView);
        monthlyText = findViewById(R.id.daymonthTV);
        moneyListView = findViewById(R.id.moneyListView);
    }

    private void setWeekView() {
        monthlyText.setText(dayMonthYearFromDate(selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(selectedDate);

        CalenderAdapter calenderAdapter = new CalenderAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calenderAdapter);
        setMoneyAdapter();

    }


    public void prevWeekAction(View view) {
        selectedDate = selectedDate.minusWeeks(1);
        setWeekView();
    }

    public void nextWeekAction(View view) {
        selectedDate = selectedDate.plusWeeks(1);
        setWeekView();
    }

    @Override
    public void onItemClick(int position, LocalDate date) {

        selectedDate = date;
        setWeekView();
    }
    
    @Override
    protected void onResume(){
        super.onResume();
        setMoneyAdapter();
    }

    private void setMoneyAdapter() {
        ArrayList<Values> dailyValues = Values.valuesForDate(selectedDate);
        moneyAdapter MoneyAdapted = new moneyAdapter(getApplicationContext(), dailyValues);
        moneyListView.setAdapter(MoneyAdapted);
    }

    public void newMoneyAction(View view) {
        startActivity(new Intent(this, moneyActivity.class));
    }
}