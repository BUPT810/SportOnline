package com.vac.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.vac.sportapp.R;

/**
 * Created by vac on 2016/7/27.
 */
public class OrderGym extends Activity {

    private Toolbar ordergym_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    public void initView(){
        ordergym_toolbar = (Toolbar) findViewById(R.id.ordergym_toolbar);
        ordergym_toolbar.setNavigationIcon(R.mipmap.back);
        ordergym_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
