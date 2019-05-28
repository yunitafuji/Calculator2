package com.example.calculator2;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button calculate;
    EditText value1, value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void output(View view){
        switch (view.getId()){
            case R.id.calculate:
                EditText v1 = (EditText)findViewById(R.id.value1);
                EditText v2 = (EditText)findViewById(R.id.value2);
                Spinner s = (Spinner)findViewById(R.id.spinner);
                String op = (String)s.getSelectedItem();
                Double n1 = null;
                Double n2 = null;

                try {
                    n1 = Double.parseDouble(v1.getText().toString());
                }
                catch (Exception E) {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    n1 = 0.0;
                }
                try {
                    n2 = Double.parseDouble(v2.getText().toString());
                }
                catch (Exception E) {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    n2 = 0.0;
                }

                Double h = 0.0;
                if(op.equals("add")){
                    h=n1+n2;
                }
                else if(op.equals("substract")){
                    h=n1-n2;
                }
                else if(op.equals("multiply")){
                    h=n1*n2;
                }
                else if(op.equals("divide")){
                    if(n2 == 0){
                        h = 0.0;
                    }
                    h=n1/n2;
                }
                TextView v = (TextView)findViewById(R.id.answer);
                v.setText("Answer: " + h);
        }

    }
}
