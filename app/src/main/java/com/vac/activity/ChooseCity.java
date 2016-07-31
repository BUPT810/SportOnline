package com.vac.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.vac.sportapp.FFirstFragment;
import com.vac.sportapp.MainActivity;
import com.vac.sportapp.R;

/**
 * Created by vac on 2016/7/17.
 */
public class ChooseCity extends Activity {
    private Toolbar toolbar;

    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;

    private Intent intent;
    private String current_cityName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.choosecity);
        intent = getIntent();
        current_cityName = intent.getStringExtra("cityName");
        initView();
    }

    public void initView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.back);
        //navigateUpTo()
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("cityName",current_cityName);
                setResult(FFirstFragment.RESULTCODE_CHOOSECITY,intent);
                finish();
            }
        });
        //jinxing genggai
        expandableListView = (ExpandableListView) findViewById(R.id.expandListView);
        adapter = new MyExpandableListAdapter(this);
        expandableListView.setAdapter(adapter);
        //设置都展开
        for(int i = 0;i < adapter.getGroupCount();i++){
            expandableListView.expandGroup(i);
        }
        //屏蔽点击group展开和关闭
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
        //设置点击child事件
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent();
                intent.putExtra("cityName",expandableListView.getExpandableListAdapter().
                        getChild(groupPosition,childPosition).toString());
                setResult(FFirstFragment.RESULTCODE_CHOOSECITY,intent);
                finish();
                return true;
            }
        });
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.a:expandableListView.setSelectedGroup(0);
                break;
            case R.id.b:expandableListView.setSelectedGroup(1);
                break;
            case R.id.c:expandableListView.setSelectedGroup(2);
                break;
            case R.id.d:expandableListView.setSelectedGroup(3);
                break;
            case R.id.e:expandableListView.setSelectedGroup(4);
                break;
            case R.id.f:expandableListView.setSelectedGroup(5);
                break;
            case R.id.g:expandableListView.setSelectedGroup(6);
                break;
            case R.id.h:expandableListView.setSelectedGroup(7);
                break;
            case R.id.j:expandableListView.setSelectedGroup(8);
                break;
            case R.id.k:expandableListView.setSelectedGroup(9);
                break;
            case R.id.l:expandableListView.setSelectedGroup(10);
                break;
            case R.id.m:expandableListView.setSelectedGroup(11);
                break;
            case R.id.n:expandableListView.setSelectedGroup(12);
                break;
            case R.id.o:expandableListView.setSelectedGroup(13);
                break;
            case R.id.p:expandableListView.setSelectedGroup(14);
                break;
            case R.id.q:expandableListView.setSelectedGroup(15);
                break;
            case R.id.r:expandableListView.setSelectedGroup(16);
                break;
            case R.id.s:expandableListView.setSelectedGroup(17);
                break;
            case R.id.t:expandableListView.setSelectedGroup(18);
                break;
            case R.id.w:expandableListView.setSelectedGroup(19);
                break;
            case R.id.x:expandableListView.setSelectedGroup(20);
                break;
            case R.id.y:expandableListView.setSelectedGroup(21);
                break;
            case R.id.z:expandableListView.setSelectedGroup(22);
                break;

        }
    }
}
