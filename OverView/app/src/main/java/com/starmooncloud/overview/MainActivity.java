package com.starmooncloud.overview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println();

        TextView tv1;
        tv1 = (TextView) findViewById(R.id.textView1);
        Switch sw;
        ImageView image1;
        image1 = (ImageView) findViewById(R.id.image1);
        sw = (Switch) findViewById(R.id.switch1);

        tv1.setText("자바에서 설정");
        tv1.setTextColor(Color.RED);
        tv1.setTextSize(30);
        tv1.setTypeface(Typeface.SANS_SERIF,
                Typeface.BOLD_ITALIC);
        btn = (Button) findViewById(R.id.button1);

        RadioButton rb1;
        RadioButton rb2;

        rb1 = (RadioButton) findViewById(R.id.male);
        rb2 = (RadioButton) findViewById(R.id.female);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "버튼을 눌렀어요", Toast.LENGTH_SHORT).show();
                rb1.setEnabled(!rb1.isEnabled());
                rb2.setEnabled(!rb2.isEnabled());

            }
        });

        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw.isChecked()){
                    image1.setVisibility(View.VISIBLE);
                }else{
                    image1.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}