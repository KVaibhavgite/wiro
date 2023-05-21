package com.example.wiro;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView marquee_text;
    Button normalbtn,custombtn;

    private Switch mode_switch;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to use marquee text /moving text in android
     marquee_text = findViewById(R.id.marquee_text);
     marquee_text.setSelected(true);


     normalbtn = findViewById(R.id.normalToastBtn);
     custombtn = findViewById(R.id.customToastBtn);
     mode_switch = findViewById(R.id.switch1);
     mode_switch.setOnCheckedChangeListener((buttonView, isChecked) -> {
         if(isChecked){
             AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
         }else{
             AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
         }
     });

     //normal toast message
        normalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Its normal toast message.", Toast.LENGTH_SHORT).show();
            }
        });

        //custom toast message
        custombtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View toastview = layoutInflater.inflate(R.layout.customtoast_layout,(ViewGroup)findViewById(R.id.toastlayout));
                ImageView img = toastview.findViewById(R.id.imageView);
                img.setImageResource(R.drawable.baseline_front_hand_24);
                TextView text = toastview.findViewById(R.id.textView);
                text.setText("Opps ! Wrong implimentation.");
               Toast toast = new Toast(getApplicationContext());
               toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
               toast.setDuration(Toast.LENGTH_LONG);
               toast.setView(toastview);
               toast.show();

            }
        });
    }
}