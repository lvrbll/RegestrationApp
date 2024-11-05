package com.example.regestrationapp;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button confirmButton;
    private EditText email;
    private EditText password;
    private EditText passwordConfirm;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        confirmButton = findViewById(R.id.buttonConfirm);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        passwordConfirm = findViewById(R.id.passwordConfirm);
        info = findViewById(R.id.info);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                String x = String.valueOf(email.getText());
                String p1= String.valueOf(password.getText());
                String p2 = String.valueOf(passwordConfirm.getText());

                if(x.contains("@")){
                    count++;
                } else {
                    info.setText("Nieprawidłowy adres e-mail");
                }


                if(!(p1.isEmpty())){
                    if(!(p2.isEmpty())){
                        if(p1.equals(p2)){
                            count++;
                        } else {
                            info.setText("Hasła się różnią");
                        }
                    } else {
                        info.setText("Hasła się różnią");
                    }
                } else {
                    info.setText("Hasła się różnią");
                }

                if(count==2){
                    info.setText("Witaj " + x);
                }
            }
        });
    }
}