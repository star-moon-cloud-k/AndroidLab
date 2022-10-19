package com.starmooncloud.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button button1, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseLayout.setBackgroundColor(Color.WHITE);
                button1.setRotation(0);
                button1.setScaleY(1);
                button1.setScaleX(1);
            }
        });

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();

        if(v==button1){menu.setHeaderTitle("배경색 변경"); menuInflater.inflate(R.menu.menu1 , menu);}
        if(v==button2){menu.setHeaderTitle("버튼 변경"); menuInflater.inflate(R.menu.menu2 , menu);}

    }


    //    //findByViewId같은 개념
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        super.onCreateOptionsMenu(menu);
//
//        menuInflater.inflate(R.menu.menu1, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        super.onOptionsItemSelected(item);
//        switch (item.getItemId())
//        {
//            case R.id.itemRed:
//                baseLayout.setBackgroundColor(Color.RED);
//                break;
//            case R.id.itemGreen:
//                baseLayout.setBackgroundColor(Color.GREEN);
//                break;
//            case R.id.itemBlue:
//                baseLayout.setBackgroundColor(Color.BLUE);
//                break;
//            case R.id.subRotate:
//                button1.setRotation(45);
//                break;
//            case R.id.subSize:
//                button1.setScaleX(2);
//                button1.setScaleY(2);
//                break;
//            default:
//        }
//        return false;
//    }
}