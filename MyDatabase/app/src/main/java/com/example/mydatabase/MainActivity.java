package com.example.mydatabase;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText name, surname, mark;
    Database database = new Database(this);
    TextView dis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        name = (EditText) findViewById(R.id.ed1);
        surname = (EditText) findViewById(R.id.ed2);
        mark = (EditText) findViewById(R.id.ed3);
        dis = (TextView) findViewById(R.id.display);
        displayData();
    }

    public void handleClick(View view) {
        String nameStr, surnameStr;
        int markInt;
        nameStr = name.getText().toString();
        surnameStr = surname.getText().toString();
        markInt = Integer.parseInt(mark.getText().toString());
        Boolean result = database.insertdata(nameStr, surnameStr, markInt);
        if (result == true) {
            Toast.makeText(getApplicationContext(), "Data inserted Sucessfully", Toast.LENGTH_SHORT).show();
            displayData();
        } else {
            Toast.makeText(getApplicationContext(), "Data inserted failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void displayData() {
        Cursor res = database.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if (res != null && res.getCount() > 0) {
            while (res.moveToNext()) {
                stringBuffer.append("Id: " + res.getString(0) + "\n");
                stringBuffer.append("Name: " + res.getString(1) + "\n");
                stringBuffer.append("Surname: " + res.getString(2) + "\n");
                stringBuffer.append("marks: " + res.getString(3) + "\n");
            }
            dis.setText(stringBuffer.toString());
        }
    }
}