package com.vac.sportapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener{

    public  static final int FIRST_PAGE = 0;
    public static final int SECOND_PAGE = 1;
    public static final int THIRD_PAGE = 2;
    public static final int FORTH_PAGE = 3;

    private RadioButton rb_first,rb_second,rb_third,rb_forth;
    private Button rb_center;
    private RadioGroup radioGroup;
    private ViewPager viewPager;


    private PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        initView();
    }

    private void initView(){
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rb_first = (RadioButton) findViewById(R.id.rb_first);
        rb_second = (RadioButton) findViewById(R.id.rb_second);
        rb_third = (RadioButton) findViewById(R.id.rb_third);
        rb_forth = (RadioButton) findViewById(R.id.rb_forth);
        rb_center = (Button) findViewById(R.id.rb_center);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        radioGroup.setOnCheckedChangeListener(MainActivity.this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);
        rb_first.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_first:
                switch (viewPager.getCurrentItem()){
                    case FIRST_PAGE:break;
                    case SECOND_PAGE:
                        viewPager.setCurrentItem(FIRST_PAGE);break;
                    case THIRD_PAGE:
                        viewPager.setCurrentItem(FIRST_PAGE,false);break;
                    case FORTH_PAGE:
                        viewPager.setCurrentItem(FIRST_PAGE,false);break;
                }
                break;
            case R.id.rb_second:
                switch (viewPager.getCurrentItem()){
                    case FIRST_PAGE:
                        viewPager.setCurrentItem(SECOND_PAGE);break;
                    case SECOND_PAGE:break;
                    case THIRD_PAGE:
                        viewPager.setCurrentItem(SECOND_PAGE);break;
                    case FORTH_PAGE:
                        viewPager.setCurrentItem(SECOND_PAGE,false);break;
                }
                break;
            case R.id.rb_third:
                switch (viewPager.getCurrentItem()){
                    case FIRST_PAGE:viewPager.setCurrentItem(THIRD_PAGE,false);break;
                    case SECOND_PAGE:
                        viewPager.setCurrentItem(THIRD_PAGE);break;
                    case THIRD_PAGE:
                        break;
                    case FORTH_PAGE:
                        viewPager.setCurrentItem(THIRD_PAGE);break;
                }
                break;
            case R.id.rb_forth:
                switch (viewPager.getCurrentItem()){
                    case FIRST_PAGE:viewPager.setCurrentItem(FORTH_PAGE);break;
                    case SECOND_PAGE:
                        viewPager.setCurrentItem(FORTH_PAGE,false);break;
                    case THIRD_PAGE:
                        viewPager.setCurrentItem(FORTH_PAGE);break;
                    case FORTH_PAGE:break;
                }
                break;
            case R.id.rb_center:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }
    /*
    三种page滑动的情况：0：nothing  1：scrolling    2:overs crolled
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        if(state == 2){
            switch (viewPager.getCurrentItem()){
                case FIRST_PAGE:
                    rb_first.setChecked(true);break;
                case SECOND_PAGE:rb_second.setChecked(true);break;
                case THIRD_PAGE:rb_third.setChecked(true);break;
                case FORTH_PAGE:rb_forth.setChecked(true);break;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        rb_first.setChecked(true);
    }
}
