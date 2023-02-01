package ABM.bunnyCorp;

import static ABM.bunnyCorp.CalenderUtils.dayMonthYearFromDate;
import static ABM.bunnyCorp.CalenderUtils.daysInMonthArray;
import static ABM.bunnyCorp.CalenderUtils.selectedDate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CalenderAdapter.OnItemListener {

    private TextView monthlyText;
    private RecyclerView calendarRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        selectedDate = LocalDate.now();
        setMonthView();

        //assigning ID of toolbar to a variable
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(dayMonthYearFromDate(selectedDate).toString()); //Try to make it show date or change to app name?

        //uses toolbar as actionbar
        setSupportActionBar(toolbar);
    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calenderRecyclerView);
        monthlyText = findViewById(R.id.daymonthTV);
    }

    private void setMonthView() {
        monthlyText.setText(dayMonthYearFromDate(selectedDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray(selectedDate);

        CalenderAdapter calenderAdapter = new CalenderAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calenderAdapter);

    }

    public void nextMonthAction(View view) {
        selectedDate = selectedDate.plusMonths(1);
        setMonthView();
    }

    public void prevMonthAction(View view) {
        selectedDate = selectedDate.minusMonths(1);
        setMonthView();
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {

        if(date != null) {
            ArrayList<Values> test2 = (ArrayList<Values>) getIntent().getSerializableExtra("test");
            System.out.println(test2.toString());
            selectedDate = date;
            setMonthView();
        }

    }

    public void addMoney(View view){
        startActivity(new Intent(this,weekViewActivity.class));
    }

}