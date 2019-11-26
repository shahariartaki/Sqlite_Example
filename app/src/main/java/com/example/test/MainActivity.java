package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name_et,email_et,phone_et;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name_et=findViewById(R.id.et_name);
        email_et=findViewById(R.id.et_mail);
        phone_et=findViewById(R.id.et_phone);
        save=findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,email,phone;
                name=name_et.getText().toString();
                email=email_et.getText().toString();
                phone=phone_et.getText().toString();
                if (name.isEmpty()|| email.isEmpty()||phone.isEmpty()){

                    Toast.makeText(getApplicationContext(),"please fill All information",Toast.LENGTH_LONG).show();
                }
                else {
                    UserDb userDb = new UserDb(getApplicationContext());
                    model model = new model();
                    model.name=name;
                    model.email=email;
                    model.phone=phone;

                    userDb.insertUser(model);

                    Toast.makeText(getApplicationContext(),"Data is SAved",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
