package com.example.diebarista;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryRedirected extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_redirected);

        LinearLayout linearLayout = findViewById(R.id.linearContainer);

        for (int i = 0; i < 20; i++) { // Add 20 buttons for example
            Button button = new Button(this);
            button.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            button.setText("Button " + (i + 1));
            linearLayout.addView(button);
        }
    }
}
