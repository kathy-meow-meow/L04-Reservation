package sg.edu.rp.c346.id22026882.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bookBtn;
    Button resetBtn;
    EditText nameEt;
    EditText numberEt;
    EditText grpEt;
    RadioButton sBtn;
    RadioButton nsBtn;
    DatePicker datePick;
    TimePicker timePick;
    RadioGroup seatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookBtn = findViewById(R.id.bookingbtn);
        resetBtn = findViewById(R.id.resetbtn);
        seatBtn = findViewById(R.id.seatGrp);
        sBtn = findViewById(R.id.rbSmoke);
        nsBtn = findViewById(R.id.rbNoSmoke);
        nameEt = findViewById(R.id.etName);
        numberEt = findViewById(R.id.etNumber);
        grpEt = findViewById(R.id.etGroup);
        datePick = findViewById(R.id.datePicker);
        timePick = findViewById(R.id.timePicker);

        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String confirmThx = "";
                String invalid = "";
                boolean valid = true;
                String seat = "";

                if(nameEt.length()>0){
                    if((numberEt.length()>0) && (numberEt.length()==8)) {
                        if(grpEt.length()>0){
                            if(seatBtn.isEnabled()){
                                if(sBtn.isEnabled()){
                                    seat = "Smoking";
                                    confirmThx += "Name: " + nameEt.getText().toString();
                                    confirmThx += "\nNumber: " + numberEt.getText().toString();
                                    confirmThx += "\nGroup Pax: " + grpEt.getText().toString();
                                    confirmThx += "\nDate: " + datePick.getDayOfMonth() + "/" + (datePick.getMonth()+1) + "/" + datePick.getYear();
                                    confirmThx += "\nTime: " + timePick.getCurrentHour().toString() + ":" + timePick.getCurrentMinute().toString();
                                    confirmThx += "\nSeating: " + seat;
                                    String thanks = "Thank You!";
                                    Toast.makeText(MainActivity.this, thanks, Toast.LENGTH_LONG).show();
                                    Toast.makeText(MainActivity.this, confirmThx, Toast.LENGTH_LONG).show();
                                }else{
                                    seat = "Non-Smoking";
                                    confirmThx += "Name: " + nameEt.getText().toString();
                                    confirmThx += "\nNumber: " + numberEt.getText().toString();
                                    confirmThx += "\nGroup Pax: " + grpEt.getText().toString();
                                    confirmThx += "\nDate: " + datePick.getDayOfMonth() + "/" + (datePick.getMonth()+1) + "/" + datePick.getYear();
                                    confirmThx += "\nTime: " + timePick.getCurrentHour().toString() + ":" + timePick.getCurrentMinute().toString();
                                    confirmThx += "\nSeating: " + seat;
                                    String thanks = "Thank You!";
                                    Toast.makeText(MainActivity.this, thanks, Toast.LENGTH_LONG).show();
                                    Toast.makeText(MainActivity.this, confirmThx, Toast.LENGTH_LONG).show();
                                }

                            }else{
                                valid = false;
                                invalid += "Invalid Seating";
                            }
                        }else{
                            valid = false;
                            invalid += "Invalid Group Size";
                        }
                    }else{
                        valid = false;
                        invalid += "Invalid Mobile Number";
                    }
                }else{
                    valid = false;
                    invalid += "Invalid Name";
                }
                if(valid == false){
                    Toast.makeText(MainActivity.this, invalid, Toast.LENGTH_LONG).show();
                }
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean btnAftReset = true;
                nsBtn.setEnabled(btnAftReset);
                nameEt.setText("");
                numberEt.setText("");
                grpEt.setText("");
                datePick.updateDate(2020,5,1);
                timePick.setCurrentHour(19);
                timePick.setCurrentMinute(30);

            }
        });

    }
}