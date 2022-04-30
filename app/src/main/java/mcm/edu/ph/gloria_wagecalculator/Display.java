package mcm.edu.ph.gloria_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    TextView txtName, txtType, txtHours, txtWage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        txtName = findViewById(R.id.txtEmployeeName);
        txtType = findViewById(R.id.txtEmployeeType);
        txtHours = findViewById(R.id.txtHoursRendered);
        txtWage = findViewById(R.id.txtTotalWage);


        Intent i = getIntent();
        String EmployeeType = i.getStringExtra("type");
        String EmployeeName = i.getStringExtra("empName");
        Double EmployeeHours = Double.parseDouble(i.getStringExtra("hours"));


        txtName.setText("Employee Name: " +EmployeeName);
        txtType.setText("Employee Type: " + String.valueOf(EmployeeType));
        txtHours.setText("Hours Rendered: "+ String.valueOf(EmployeeHours));
        Double totalWage = 0.0;

        if(EmployeeType.equals("Full-Time")){
            totalWage = EmployeeHours * 100;
            txtWage.setText("Total Wage: " +String.valueOf(totalWage));
        }
        else if(EmployeeType.equals("Part-time")){
            totalWage = EmployeeHours * 75;
            txtWage.setText("Total Wage: " +String.valueOf(totalWage));
        }
        else{
            totalWage = EmployeeHours * 90;
            txtWage.setText("Total Wage: " +String.valueOf(totalWage));
        }
    }
}