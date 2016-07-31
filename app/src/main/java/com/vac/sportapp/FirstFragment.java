package com.vac.sportapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import info.hoang8f.android.segmented.SegmentedGroup;

/**
 * Created by vac on 2016/7/13.
 */
public class FirstFragment extends android.support.v4.app.Fragment implements
        RadioGroup.OnCheckedChangeListener{
    private View view;
    private SegmentedGroup segmentedGroup;
    private RadioButton radioButton1,radioButton2;

    private android.support.v4.app.FragmentManager manager;
    private FFirstFragment fragment1;
    private SFirstFragment fragment2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.first_fragment,container,false);
        initView();
        //显示第一个fragment
        manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        fragment1 = new FFirstFragment();
        transaction.add(R.id.container_firstfrag,fragment1,"ffirst_fragment");
        transaction.commit();
        return view;
    }

    private void initView(){
        segmentedGroup = (SegmentedGroup) view.findViewById(R.id.segmentGroup);
        radioButton1 = (RadioButton) view.findViewById(R.id.frag_rb_first);
        radioButton2 = (RadioButton) view.findViewById(R.id.frag_rb_second);
        segmentedGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragment(transaction);
        switch (checkedId){
            case R.id.frag_rb_first:
                if(fragment1 == null){
                    fragment1 = new FFirstFragment();
                    transaction.add(R.id.container_firstfrag,fragment1,"ffirst_fragment");
                }else {
                    transaction.show(fragment1);
                }
                break;
            case R.id.frag_rb_second:
                if(fragment2 == null){
                    fragment2 = new SFirstFragment();
                    transaction.add(R.id.container_firstfrag,fragment2,"sfirst_fragment");
                }else {
                    transaction.show(fragment2);
                }
                break;
        }
        transaction.commit();
    }
    //隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction){
        if(fragment1 != null){transaction.hide(fragment1);}
        if(fragment2 != null){transaction.hide(fragment2);}
    }
}
