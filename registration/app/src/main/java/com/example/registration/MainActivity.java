package com.example.registration;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText fn;
    EditText sn;
    EditText pwd;
    EditText em;
    RadioGroup tv1;
    EditText ph;
    EditText dob;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        fn=(EditText)findViewById(R.id.fn);
        sn=(EditText)findViewById(R.id.sn);
        pwd=(EditText)findViewById(R.id.pwd);
        em=(EditText)findViewById(R.id.em);
//      tv1=(RadioGroup)findViewById(R.id.tv1);
        ph=(EditText)findViewById(R.id.ph);
        dob=(EditText)findViewById(R.id.dob);
    }

    public void HandleClick(View view) {
        String firstname=fn.getText().toString();
        String secondname=sn.getText().toString();
        String password=pwd.getText().toString();
        String email=em.getText().toString();
        String phonenumber=ph.getText().toString();
        String dataeofBirth=dob.getText().toString();

        String radio_button_text = "Unknown";
        int id = tv1.getCheckedRadioButtonId();
        RadioButton selected_radio_button = (RadioButton) findViewById(id);

        if(selected_radio_button != null) {
            radio_button_text = selected_radio_button.getText().toString();
        }
    }
}