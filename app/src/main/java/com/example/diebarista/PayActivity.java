package com.example.diebarista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PayActivity extends AppCompatActivity {
    EditText n, ln, pno, hn, lm, ad, ci, pc;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        n=findViewById(R.id.name);
        ln=findViewById(R.id.lname);
        pno=findViewById(R.id.phoneno);
        hn=findViewById(R.id.houseno);
        lm=findViewById(R.id.landmark);
        ad=findViewById(R.id.address);
        ci=findViewById(R.id.city);
        pc=findViewById(R.id.postalcode);
        b=findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(PayActivity.this, payment.class);
                startActivity(in);
            }
        });

    }
}