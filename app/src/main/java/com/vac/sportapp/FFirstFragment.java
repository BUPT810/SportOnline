package com.vac.sportapp;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nineoldandroids.view.ViewHelper;
import com.vac.activity.ChooseCity;
import com.vac.activity.GymDetail;
import com.vac.activity.MyAdapterForGym;
import com.vac.activity.MyArrayAdapter;

import java.security.Policy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import info.hoang8f.android.segmented.SegmentedGroup;

/**
 * Created by vac on 2016/7/17.
 */
public class FFirstFragment extends Fragment implements MyToggleButton.OnCheckedChangeListener,
        View.OnClickListener {
    public static final int REQUESTCODE_CHOOSECITY = 0;
    public static final int RESULTCODE_CHOOSECITY = 0;

    private View view;
    private MyToggleButton myToggleButton1, myToggleButton2, myToggleButton3;

    private TextView text_choosecity, text_location_query;
    private EditText edit_query;
    private RelativeLayout relative1;

    private ImageView image;
    private LayoutInflater mInflater;
    private PopupWindow popupWindow = null;

    private ListView ff_fragment_listview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ffirst_fragment, container, false);
        this.mInflater = inflater;
        initView();
        return view;
    }

    private void initView() {
        myToggleButton1 = (MyToggleButton) view.findViewById(R.id.toggle1);
        myToggleButton2 = (MyToggleButton) view.findViewById(R.id.toggle2);
        myToggleButton3 = (MyToggleButton) view.findViewById(R.id.toggle3);
        myToggleButton1.setOnCheckedChangeListener(this);
        myToggleButton2.setOnCheckedChangeListener(this);
        myToggleButton3.setOnCheckedChangeListener(this);

        text_choosecity = (TextView) view.findViewById(R.id.text_choosecity);
        text_choosecity.setOnClickListener(this);
        text_location_query = (TextView) view.findViewById(R.id.text_location_query);
        edit_query = (EditText) view.findViewById(R.id.edit_query);

        relative1 = (RelativeLayout) view.findViewById(R.id.relative1);

        ff_fragment_listview = (ListView) view.findViewById(R.id.ff_fragment_listview);
        MyAdapterForGym myAdapterForGym = new MyAdapterForGym(getContext());
        ff_fragment_listview.setAdapter(myAdapterForGym);
        ff_fragment_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView image_gym = (ImageView) view.findViewById(R.id.image_gym);
                ImageView image_star = (ImageView)view.findViewById(R.id.image_star);
                TextView text_gymName = (TextView)view.findViewById(R.id.text_gytName);
                TextView text_type = (TextView) view.findViewById(R.id.text_type);
                TextView text_distance = (TextView) view.findViewById(R.id.text_distance);
                Drawable imageGym  = image_gym.getDrawable();
                Drawable imageStar = image_star.getDrawable();
                String gymType = text_type.getText().toString();
                String gymName = text_gymName.getText().toString();
                String distance = text_distance.getText().toString();
                Bundle bundle  = new Bundle();
                //bundle.putParcelable("imageGym", (Parcelable) imageGym);
                //bundle.putParcelable("imageStar", (Parcelable) imageStar);
                bundle.putString("gymType",gymType);
                bundle.putString("gymName",gymName);
                bundle.putString("distance",distance);
                Intent intent = new Intent(getContext(), GymDetail.class);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onCheckedChanged(MyToggleButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.toggle1:
                if (isChecked) {
                    myToggleButton3.setChecked(false);
                    myToggleButton2.setChecked(false);
                    final View popupView = mInflater.inflate(R.layout.popup1, null);
                    List<String> sports_category = Arrays.asList(this.getResources().getStringArray(R.array.sports_category));
                    final ListView listView = (ListView) popupView.findViewById(R.id.category_list_1);
                    listView.setVerticalScrollBarEnabled(false);
                    listView.setAdapter(new ArrayAdapter<String>(this.getContext(),
                            R.layout.simple_list_item,sports_category));

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            myToggleButton1.setText(parent.getAdapter().getItem(position).toString());
                            myToggleButton1.setChecked(false);
                        }
                    });
                    popupWindow = new PopupWindow(popupView, myToggleButton1.getWidth(), relative1.getHeight());
                    popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            myToggleButton1.setChecked(false);
                        }
                    });
                    popupWindow.setTouchInterceptor(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            int x = (int) event.getX();
                            int y = (int) event.getY();
                            if (0 < x && x < myToggleButton1.getWidth() &&
                                    y > -myToggleButton1.getHeight() && y < 0) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    });
                    setPopupWindow(popupWindow);
                } else {
                    if (popupWindow != null && popupWindow.isShowing()) {
                        popupWindow.dismiss();
                        popupWindow = null;
                    }
                }
                break;
            case R.id.toggle2:
                if (isChecked) {
                    myToggleButton1.setChecked(false);
                    myToggleButton3.setChecked(false);
                    View popupView = mInflater.inflate(R.layout.popup2, null);
                    init_list_toggle2(popupView);       //初始化list
                    popupWindow = new PopupWindow(popupView, relative1.getWidth(), relative1.getHeight() * 4 / 5);
                    popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            myToggleButton2.setChecked(false);
                        }
                    });
                    popupWindow.setTouchInterceptor(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            int x = (int) event.getX();
                            int y = (int) event.getY();
                            if (myToggleButton1.getWidth() < x && x < myToggleButton1.getWidth() * 2 &&
                                    y > -myToggleButton1.getHeight() && y < 0) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    });
                    setPopupWindow(popupWindow);

                } else {
                    if (popupWindow != null && popupWindow.isShowing()) {
                        popupWindow.dismiss();
                        popupWindow = null;
                    }
                }
                break;
            case R.id.toggle3:
                if (isChecked) {
                    myToggleButton1.setChecked(false);
                    myToggleButton2.setChecked(false);
                    View popupView = mInflater.inflate(R.layout.popup3, null);
                    Button bt_ok = (Button) popupView.findViewById(R.id.bt_ok);
                    bt_ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            myToggleButton3.setChecked(false);
                        }
                    });
                    popupWindow = new PopupWindow(popupView, relative1.getWidth(), relative1.getHeight() *4/ 5);
                    popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            myToggleButton3.setChecked(false);
                        }
                    });
                    popupWindow.setTouchInterceptor(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            int x = (int) event.getX();
                            int y = (int) event.getY();
                            if (myToggleButton1.getWidth()*2 < x && x < myToggleButton1.getWidth() * 3 &&
                                    y > -myToggleButton1.getHeight() && y < 0) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    });
                    setPopupWindow(popupWindow);
                } else {
                    if (popupWindow != null && popupWindow.isShowing()) {
                        popupWindow.dismiss();
                        popupWindow = null;
                    }
                }
                break;
        }
    }

    private void init_list_toggle2(View view) {
        final List<String> list_1 = new ArrayList<>(Arrays.asList(this.getContext().getResources()
                .getStringArray(R.array.district)));
        List<String> list_2 = new ArrayList<>(Arrays.asList(this.getContext().getResources()
                .getStringArray(R.array.fujin)));
        final ListView address_list_1 = (ListView) view.findViewById(R.id.address_list_1);
        address_list_1.setVerticalScrollBarEnabled(false); //去掉滚动条
        //address_list_1.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);//设置为单选模式
        ListView address_list_2 = (ListView) view.findViewById(R.id.address_list_2);
        address_list_2.setBackgroundColor(getContext().getResources().getColor(R.color.bg_white));
        address_list_2.setVerticalScrollBarEnabled(false);//去掉滚动条
        //address_list_1.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);     //设置为单选模式
       final MyArrayAdapter adapter1 = new MyArrayAdapter(this.getContext(),list_1);
        adapter1.setSelectedPosition(0);
        address_list_1.setAdapter(adapter1);
        final MyArrayAdapter adapter2 = new MyArrayAdapter(this.getContext(),list_2);

        address_list_1.setAdapter(adapter1);
        address_list_2.setAdapter(adapter2);
        address_list_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter1.setSelectedPosition(position);
                adapter1.notifyDataSetChanged();
            }
        });
        address_list_2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myToggleButton2.setText(adapter2.getItem(position).toString());
                myToggleButton2.setChecked(false);
            }
        });
    }

/*    private List<String> chooseCity() {
        List<String> data = new ArrayList<String>();
        switch(text_choosecity.getText().toString()){
            case "北京"
        }
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_choosecity:
                Intent intent = new Intent(this.getContext(),ChooseCity.class);
                intent.putExtra("cityName",text_choosecity.getText().toString());
                startActivityForResult(intent,REQUESTCODE_CHOOSECITY);
                break;
            default:
                break;
        }
    }

    //设置popupWindow
    public void setPopupWindow(final PopupWindow popupWindow) {
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.bg_gray));//设置背景
        popupWindow.setOutsideTouchable(true);//
        //popupWindow.setOverlapAnchor(true);
        popupWindow.setFocusable(false); //
        popupWindow.showAsDropDown(myToggleButton1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUESTCODE_CHOOSECITY:
                switch (requestCode){
                    case RESULTCODE_CHOOSECITY:
                        if(data != null)
                            text_choosecity.setText(data.getStringExtra("cityName"));
                        break;
                }
                break;
        }
    }
}
