package com.vac.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vac.sportapp.R;

/**
 * Created by vac on 2016/7/25.
 */
public class GymDetail extends Activity {

    private Toolbar toolbar;
    private TextView gymdetaile_gymName;
    private TextView gymdetail_gymType;
    private ImageView gymdetail_fstars;
    private LinearLayout line1;
    private TextView gymdetail_location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ffirst_gymdetail);
        toolbar = (Toolbar) findViewById(R.id.gymdetail_toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.inflateMenu(R.menu.ffirst_gymdetail_menu);
        initView();
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        //Drawable imageGym = (Drawable) bundle.getParcelable("imageGym");
        //Drawable imageStar = (Drawable)bundle.getParcelable("imageStar");
        String gymName = bundle.getString("gymName");
        String gymType = bundle.getString("gymType");
        String distance = bundle.getString("distance");
        gymdetaile_gymName.setText(gymName);
        //gymdetail_fstars.setImageDrawable(imageStar);
        gymdetail_gymType.setText(gymType);
        //line1.setBackground(imageGym);
    }

    public void initView(){
        gymdetaile_gymName = (TextView) findViewById(R.id.gymdetaile_gymName);
        gymdetail_fstars = (ImageView) findViewById(R.id.gymdetail_fstars);
        gymdetail_gymType = (TextView) findViewById(R.id.gymdetail_gymType);
        line1 = (LinearLayout) findViewById(R.id.line1);
        gymdetail_location = (TextView) findViewById(R.id.gymdetail_location);
        gymdetail_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GymDetail.this,GymMap.class);
                double latitude = 39.963175;
                double longitude = 116.400244;
                intent.putExtra("latitude",latitude);       //39.963175, 116.400244
                intent.putExtra("longitude",longitude);
                startActivity(intent);
            }
        });
    }
}
