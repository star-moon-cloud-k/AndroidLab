package com.starmooncloud.basic20220914;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //변수 만들기
    TextView result;
    Integer amount = 0;
    Button[] subButtons = new Button[7];
    Button[] addButtons = new Button[7];
    TextView[] textViews = new TextView[7];
    TextView[] costViews = new TextView[7];

    Integer[] subButtonIds  = {R.id.stSub, R.id.okSub, R.id.ykSub ,R.id.oknSub, R.id.cokeSub, R.id.spriteSub, R.id.tonicSub};
    Integer[] addButtonIds  = {R.id.stAdd, R.id.okAdd, R.id.ykAdd ,R.id.oknAdd, R.id.cokeAdd, R.id.spriteAdd, R.id.tonicAdd};
    Integer[] textViewIds  = {R.id.stText, R.id.okText, R.id.ykText ,R.id.oknText, R.id.cokeText, R.id.spriteText, R.id.tonicText};
    Integer[] costIds = {R.id.stCost, R.id.okCost, R.id.ykCost ,R.id.oknCost, R.id.cokeCost, R.id.spriteCost, R.id.tonicCost};

    int i; //증가값 용도
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("테이블레이아웃 계산기");

;

        result = (TextView) findViewById(R.id.costResult);

        for(i=0; i< subButtons.length; i++){
            subButtons[i] = (Button) findViewById(subButtonIds[i]);
            addButtons[i] = (Button) findViewById(addButtonIds[i]);
            textViews[i] = (TextView) findViewById(textViewIds[i]);
            costViews[i] = (TextView) findViewById(costIds[i]);

        }

        for(i=0; i<subButtons.length;i++){
            final int index;
            index=i;
            subButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String number = textViews[index].getText().toString();
                    Integer num = Integer.parseInt(number);
                    if (num <= 0) {
                        Toast.makeText(getApplicationContext(), "더 이상 뺄 수 없습니다.", Toast.LENGTH_SHORT).show();

                    } else {
                        number = costViews[index].getText().toString();
                        number = number.replace("," ,"");
                        Integer cost = Integer.parseInt(number);
                        amount = amount-(cost * num);
                        num -= 1;
                        textViews[index].setText(num.toString());
                        result.setText("가격 : " + amount.toString());
                    }

                }
            });
        }
        for(i=0; i<addButtons.length;i++){
            final int index;
            index=i;
            addButtons[index].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    String number = textViews[index].getText().toString();
                    Integer num = Integer.parseInt(number);

                    number = costViews[index].getText().toString();
                    number = number.replace("," ,"");
                    Integer cost = Integer.parseInt(number);
                    num += 1;
                    amount = amount + (cost * num);
                    textViews[index].setText(num.toString());
                    result.setText("가격 : " + amount.toString());


                }
            });
        }




    }

}