package com.vac.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.vac.sportapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by vac on 2016/7/27.
 */
public class OrderGym extends Activity {

    private Toolbar ordergym_toolbar;
    private int gridColNums = 15;
    private int gridWidth;
    private final int gridItemWidth = 40;
    private RadioButton date_1, date_2, date_3, date_4, date_5;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordergym);
        initView();

    }

    public void initView() {
        ordergym_toolbar = (Toolbar) findViewById(R.id.ordergym_toolbar);
        ordergym_toolbar.setNavigationIcon(R.mipmap.back);
        ordergym_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd");
        String date=sdf.format(new java.util.Date());
        Log.i("LOG",date);
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        date_1 = (RadioButton) findViewById(R.id.date_1);
        date_2 = (RadioButton) findViewById(R.id.date_2);
        date_3 = (RadioButton) findViewById(R.id.date_3);
        date_4 = (RadioButton) findViewById(R.id.date_4);
        date_5 = (RadioButton) findViewById(R.id.date_5);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

}
