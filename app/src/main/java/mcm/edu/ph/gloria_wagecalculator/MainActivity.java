package mcm.edu.ph.gloria_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public abstract class MainActivity extends AppCompatActivity implements View.OnLongClickListener{

    EditText employeeName, employeeHours;
    RadioGroup employeeType;
    RadioButton btnSelected;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeName = findViewById(R.id.employeeName);
        employeeHours = findViewById(R.id.employeeHours);

        employeeType = findViewById(R.id.employeeType);

        calculate = findViewById(R.id.btnCalculate);


        calculate.setOnClickListener((View.OnClickListener) this);

    }
    public void Onclick(View v) {

        switch(v.getId()){
            case R.id.btnCalculate:
                    int selectedEmployeeType = employeeType.getCheckedRadioButtonId();

                    btnSelected = findViewById(selectedEmployeeType);

                    String type = btnSelected.getText().toString();

                    String name = employeeName.getText().toString();
                    Double totalHours = Double.parseDouble(employeeHours.getText().toString());

                    Intent intent = new Intent(this,Display.class);

                    intent.putExtra("type", type);
                    intent.putExtra("empName", name);
                    intent.putExtra("hours",totalHours);
                    startActivity(intent);

                break;
        }
    }
}