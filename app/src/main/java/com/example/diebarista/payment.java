package com.example.diebarista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class payment extends AppCompatActivity {
    RadioButton rb;
    ImageView back;
    RadioGroup rg1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        back=findViewById(R.id.bb);
        Fragment f;
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        rg1=findViewById(R.id.rg);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb=findViewById(checkedId);
                String text=rb.getText().toString();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void chgFrag(View v){
        Fragment f;
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (v == findViewById(R.id.r1)){
            f=new creditCard();
            ft.replace(R.id.fragarea, f);
            ft.commit();
        } else if (v == findViewById(R.id.r2)){
            f=new debitCard();
            ft.replace(R.id.fragarea, f);
            ft.commit();
        }
        else if (v == findViewById(R.id.r3)){
            f=new upi();
            ft.replace(R.id.fragarea, f);
            ft.commit();
        }
        else if (v == findViewById(R.id.r4)){
            f=new cod();
            ft.replace(R.id.fragarea, f);
            ft.commit();
        }
    }
}